package com.example.PincodeDistance.model;

public class RouteResponse {

    private String fromPincode;
    private String toPincode;
    private double distance;
    private String duration;

    // Constructor
    public RouteResponse(String fromPincode, String toPincode, double distance, String duration) {
        this.fromPincode = fromPincode;
        this.toPincode = toPincode;
        this.distance = distance;
        this.duration = duration;
    }

    // Getters and Setters
    public String getFromPincode() {
        return fromPincode;
    }

    public void setFromPincode(String fromPincode) {
        this.fromPincode = fromPincode;
    }

    public String getToPincode() {
        return toPincode;
    }

    public void setToPincode(String toPincode) {
        this.toPincode = toPincode;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
