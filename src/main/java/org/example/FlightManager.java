package org.example;

public class FlightManager {

        private Flight flight;

        public FlightManager(Flight flight) {
            this.flight = flight;
        }

        public int getBaggageWeightPerPassenger() {
            return this.flight.getPlane().getTotalWeight() / 2 / this.flight.getPlane().getCapacity();
        }

        public int getBaggageWeightBooked() {
            int total = 0;
            for (Passenger passenger : this.flight.getPassengers()) {
                total += passenger.getBags();
            }
            return total * this.getBaggageWeightPerPassenger();
        }

        public int getRemainingBaggageWeight() {
            return this.flight.getPlane().getTotalWeight() / 2 - this.getBaggageWeightBooked();
        }
}
