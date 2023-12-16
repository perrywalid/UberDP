package org.example.Trip;

import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;
import org.example.Trip.Strategy.FareCalculatorStrategy;

public class Trip {

    private int id;
    private Customer customer;
    private Driver driver;
    private String pickupLocation;
    private String dropoffLocation;
    private String pickupTime;
    private double distance;
    private double duration;
    private boolean isCompleted;
    private double fare;
    private FareCalculatorStrategy fareCalculatorStrategy;
    private float rating;

    public double calculateFare() {
        fare = fareCalculatorStrategy.calculateFare(this);
        return fare;
    }

    public Trip(int id, Customer customer, Driver driver, String pickupLocation, String dropoffLocation, String pickupTime, double distance, double duration, boolean isCompleted, double fare, FareCalculatorStrategy fareCalculatorStrategy, float rating) {
        this.id = id;
        this.customer = customer;
        this.driver = driver;
        this.pickupLocation = pickupLocation;
        this.dropoffLocation = dropoffLocation;
        this.pickupTime = pickupTime;
        this.distance = distance;
        this.duration = duration;
        this.isCompleted = isCompleted;
        this.fare = fare;
        this.fareCalculatorStrategy = fareCalculatorStrategy;
        this.rating = rating;
    }

    public String getPickupLocation() {
        return pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public String getDropoffLocation() {
        return dropoffLocation;
    }

    public void setDropoffLocation(String dropoffLocation) {
        this.dropoffLocation = dropoffLocation;
    }

    public String getPickupTime() {
        return pickupTime;
    }

    public void setPickupTime(String pickupTime) {
        this.pickupTime = pickupTime;
    }
    public void setFareCalculatorStrategy(FareCalculatorStrategy fareCalculatorStrategy) {
        this.fareCalculatorStrategy = fareCalculatorStrategy;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public FareCalculatorStrategy getFareCalculatorStrategy() {
        return fareCalculatorStrategy;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "customer=" + customer +
                ", driver=" + driver +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropoffLocation='" + dropoffLocation + '\'' +
                ", pickupTime='" + pickupTime + '\'' +
                ", distance=" + distance +
                ", duration=" + duration +
                ", isCompleted=" + isCompleted +
                ", fare=" + fare +
                ", fareCalculatorStrategy=" + fareCalculatorStrategy +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
