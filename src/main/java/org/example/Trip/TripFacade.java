package org.example.Trip;

import org.example.Database;
import org.example.Trip.Strategy.BasicFareCalculator;
import org.example.Trip.Strategy.SurgePricingCalculator;
import org.example.Trip.Builder.TripBuilder;
import org.example.Trip.User.Customer;
import org.example.Trip.User.Driver;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class TripFacade {
    public Trip requestTrip(String pickupLocation, String destination, String pickupTime, Customer customer) {
        Trip trip = new TripBuilder()
                .setPickupLocation(pickupLocation)
                .setDestination(destination)
                .setPickupTime(pickupTime)
                .setCustomer(customer)
                .build();
        Random rand = new Random();
        trip.setDistance(rand.nextInt(100));
        trip.setDuration(rand.nextInt(100));
        if(rand.nextInt(2) == 0) {
            trip.setFareCalculatorStrategy(new SurgePricingCalculator());
        }
        else {
            trip.setFareCalculatorStrategy(new BasicFareCalculator());
        }
        trip.calculateFare();
        Database.getInstance().saveTrip(trip);
        return trip;
    }
    public List<Trip> findAvailableTrips() {
        List<Trip> list = Database.getInstance().findAvailableTrips();
        return list;
    }
    public void assignDriverToTrip(Driver driver, Trip trip) {
        Database.getInstance().assignDriverToTrip(driver, trip);
    }
    public void completeTrip(Trip trip, float rating) {
        trip.setRating(rating);
        Database.getInstance().completeTrip(trip);
    }
    public List<Trip> getTripsByCustomer(Customer customer, boolean isCompleted) {
        List<Trip> trips = customer.getTrips();
        List<Trip> filteredTrips = new LinkedList<>();
        for(Trip trip : trips) {
            if(trip.isCompleted() == isCompleted) {
                filteredTrips.add(trip);
            }
        }
        return filteredTrips;
    }
    public List<Trip> getTripsByDriver(Driver driver) {
        List<Trip> trips = driver.getTrips();
        return trips;
    }
}
