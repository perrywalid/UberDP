package org.example.Trip.Builder;

import org.example.Trip.Strategy.FareCalculatorStrategy;
import org.example.Trip.Trip;
import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;

public interface TripBuilderInterface {
    public TripBuilderInterface setPickupLocation(String pickupLocation);
    public TripBuilderInterface setDestination(String destination);
    public TripBuilderInterface setPickupTime(String pickupTime);
    public TripBuilderInterface setCustomer(Customer customer);
    public TripBuilderInterface setFareCalculatorStrategy(FareCalculatorStrategy fareCalculatorStrategy);
    public TripBuilderInterface setDriver(Driver driver);
    public TripBuilderInterface setDistance(double distance);
    public TripBuilderInterface setDuration(double duration);

    TripBuilderInterface setIsCompleted(boolean isCompleted);

    TripBuilderInterface setFare(double fare);

    public Trip build();
}
