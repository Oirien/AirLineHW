package org.example;

public class Passenger {
    String name;
    int bags;

    Flight flight;

    int seatNumber;

    public Passenger(String name, int bags) {
        this.name = name;
        this.bags = bags;
    }

    public int getBags() {
        return bags;
    }
    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }
}
