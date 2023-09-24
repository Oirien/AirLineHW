package org.example;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;

public class Flight {
    private Pilot pilot;
    private ArrayList<CabinCrewMember> cabinCrew;
    private ArrayList<Passenger> passengers;

    private Plane plane;
    private String flightNumber;
    private String destination;
    private String departureAirport;
    private Date departureTime;
    private Set<Integer> assignedSeats;

    public Flight(Pilot pilot, String flightNumber, String destination, String departureAirport, Date departureTime, ArrayList<CabinCrewMember> cabinCrew, Plane plane, Set<Integer> assignedSeats) {
        this.pilot = pilot;
        this.cabinCrew = cabinCrew;
        this.passengers = new ArrayList<>();
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.assignedSeats = new HashSet<>();

    }

    public Pilot getPilot() {
        return pilot;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public int getNumberOfAvailableSeats() {
        return this.plane.getCapacity() - this.passengers.size();
    }

    public int generateSeatNumber() {
        return (int) (Math.random() * (this.plane.getCapacity()));
    }

    public void bookPassenger(Passenger passenger) {
        if (this.getNumberOfAvailableSeats() > 0) {
            this.passengers.add(passenger);
            passenger.setFlight(this);
            int seatNumber = generateSeatNumber();
            while (passenger.getSeatNumber() != seatNumber) {
                if (this.assignedSeats.contains(seatNumber)) {
                    seatNumber = generateSeatNumber();
                } else {
                    passenger.setSeatNumber(seatNumber);
                    addAssignedSeats(seatNumber);
                    break;
                }
            }
        }
    }

    private void addAssignedSeats(int seatNumber) {
        this.assignedSeats.add(seatNumber);
    }


    public Plane getPlane() {
        return plane;
    }

    public String getPlaneName() {
        return this.plane.getName();
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public Set<Integer> getAssignedSeats() {
        return assignedSeats;
    }
}
