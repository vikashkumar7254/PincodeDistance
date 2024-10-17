package com.example.PincodeDistance.service;

import com.example.PincodeDistance.model.Route;
import com.example.PincodeDistance.model.RouteResponse;
import com.example.PincodeDistance.repository.RouteRepository;
import com.google.maps.DistanceMatrixApi;
import com.google.maps.GeoApiContext;
import com.google.maps.model.DistanceMatrix;
import com.google.maps.model.DistanceMatrixRow;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import java.util.concurrent.TimeUnit;
import java.util.Optional;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    @Autowired
    private GeoApiContext geoApiContext;

    @Transactional
    @Cacheable(value = "routes", key = "#fromPincode + '-' + #toPincode")
    public RouteResponse getRoute(String fromPincode, String toPincode) throws Exception {
        // Check if the route exists in the database
        Optional<Route> existingRoute = routeRepository.findByFromPincodeAndToPincode(fromPincode, toPincode);
        if (existingRoute.isPresent()) {
            return convertToResponse(existingRoute.get());
        }

        // Fetch from Google Maps API
        DistanceMatrix matrix = DistanceMatrixApi.getDistanceMatrix(geoApiContext,
                new String[]{fromPincode}, new String[]{toPincode}).await();

        if (matrix.rows.length == 0 || matrix.rows[0].elements.length == 0 ||
                matrix.rows[0].elements[0].distance == null || matrix.rows[0].elements[0].duration == null) {
            throw new Exception("No valid route found between the provided pin codes.");
        }

        double distanceInMeters = matrix.rows[0].elements[0].distance.inMeters;
        long durationInSeconds = matrix.rows[0].elements[0].duration.inSeconds;

        // Convert to kilometers and human-readable time
        double distanceInKilometers = distanceInMeters / 1000;
        String durationFormatted = formatDuration(durationInSeconds);

        // Save to database
        Route route = new Route(null, fromPincode, toPincode, distanceInKilometers, durationInSeconds);
        routeRepository.save(route);

        return new RouteResponse(fromPincode, toPincode, distanceInKilometers, durationFormatted);
    }

    private String formatDuration(long durationInSeconds) {
        long hours = TimeUnit.SECONDS.toHours(durationInSeconds);
        long minutes = TimeUnit.SECONDS.toMinutes(durationInSeconds) - (hours * 60);
        long seconds = durationInSeconds - (hours * 3600 + minutes * 60);

        return String.format("%02d hours, %02d minutes, %02d seconds", hours, minutes, seconds);
    }

    private RouteResponse convertToResponse(Route route) {
        String durationFormatted = formatDuration(route.getDuration());
        return new RouteResponse(route.getFromPincode(), route.getToPincode(), route.getDistance(), durationFormatted);
    }
}
