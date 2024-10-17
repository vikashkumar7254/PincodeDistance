package com.example.PincodeDistance.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromPincode;
    private String toPincode;
    private double distance;  // in kilometers
    private long duration;    // in seconds

    // Constructors, Getters, and Setters
    public Route() {}

    public Route(Long id, String fromPincode, String toPincode, double distance, long duration) {
        this.id = id;
        this.fromPincode = fromPincode;
        this.toPincode = toPincode;
        this.distance = distance;
        this.duration = duration;
    }

    public String getFromPincode() {
        return fromPincode;
    }

    public String getToPincode() {
        return toPincode;
    }

    public double getDistance() {
        return distance;
    }

    public long getDuration() {
        return duration;
    }
}
