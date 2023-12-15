package org.example.Trip.Strategy;

import org.example.Trip.Trip;

public class SurgePricingCalculator implements FareCalculatorStrategy {
    @Override
    public double calculateFare(Trip trip) {
        return 2 * trip.getDistance() + 1 * trip.getDuration();
    }
}
