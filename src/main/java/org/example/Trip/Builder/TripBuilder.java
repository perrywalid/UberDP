package org.example.Trip.Builder;

import org.example.Trip.Strategy.FareCalculatorStrategy;
import org.example.Trip.Trip;
import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;

public class TripBuilder implements TripBuilderInterface {

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
    private int id;

    @Override
    public TripBuilderInterface setPickupLocation(String pickupLocation){
        this.pickupLocation = pickupLocation;
        return this;
    }
    @Override
    public TripBuilderInterface setDestination(String destination){
        this.dropoffLocation = destination;
        return this;
    }
    @Override
    public TripBuilderInterface setPickupTime(String pickupTime){
        this.pickupTime = pickupTime;
        return this;
    }
    @Override
    public TripBuilderInterface setCustomer(Customer customer){
        this.customer = customer;
        return this;
    }
    @Override
    public TripBuilderInterface setFareCalculatorStrategy(FareCalculatorStrategy fareCalculatorStrategy){
        this.fareCalculatorStrategy = fareCalculatorStrategy;
        return this;
    }
    @Override
    public TripBuilderInterface setDriver(Driver driver){
        this.driver = driver;
        return this;
    }
    @Override
    public TripBuilderInterface setDistance(double distance){
        this.distance = distance;
        return this;
    }
    @Override
    public TripBuilderInterface setDuration(double duration){
        this.duration = duration;
        return this;
    }
    @Override
    public TripBuilderInterface setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
        return this;
    }
    @Override
    public TripBuilderInterface setFare(double fare){
        this.fare = fare;
        return this;
    }
    @Override
    public TripBuilderInterface setID(int id){
        this.id = id;
        return this;
    }
    @Override
    public TripBuilderInterface setRating(float rating){
        this.rating = rating;
        return this;
    }
    @Override
    public Trip build(){
        return new Trip(id, customer, driver, pickupLocation, dropoffLocation, pickupTime, distance, duration, isCompleted, fare, fareCalculatorStrategy, rating);
    }
}
