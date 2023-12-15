package org.example.Trip;

import org.example.Database;
import org.example.Trip.Strategy.BasicFareCalculator;
import org.example.Trip.Strategy.SurgePricingCalculator;
import org.example.Trip.Builder.TripBuilder;
import org.example.Trip.User.Customer;

import java.util.List;
import java.util.Random;

import static org.example.Database.getInstance;

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
        getInstance().saveTrip(trip);
        return trip;
    }
    public List<Trip> findAvailableTrips() {
        List<Trip> list = Database.getInstance().findAvailableTrips();
        for(Trip trip : list) {
            System.out.println(trip.toString());
        }
        return list;
    }
}
