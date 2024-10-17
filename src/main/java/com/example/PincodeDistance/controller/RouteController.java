package com.example.PincodeDistance.controller;

import com.example.PincodeDistance.model.RouteResponse;
import com.example.PincodeDistance.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @GetMapping(produces = "application/json")
    public RouteResponse getRoute(@RequestParam String fromPincode, @RequestParam String toPincode) throws Exception {
        return routeService.getRoute(fromPincode, toPincode);
    }
}
