package org.example.Trip.Strategy;

import org.example.Trip.Trip;

public class BasicFareCalculator implements FareCalculatorStrategy {
    @Override
    public double calculateFare(Trip trip) {
        return 1.5 * trip.getDistance() + 0.5 * trip.getDuration();
    }
}
