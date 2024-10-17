package com.example.PincodeDistance.repository;

import com.example.PincodeDistance.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RouteRepository extends JpaRepository<Route, Long> {
    Optional<Route> findByFromPincodeAndToPincode(String fromPincode, String toPincode);
}
