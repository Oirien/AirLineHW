package org.example;

import org.junit.Before;
import org.junit.Test;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.*;

public class FlightTest {
    Flight flight;
    Pilot pilot;
    Plane plane;
    Passenger passenger;
    Passenger passenger2;
    Passenger passenger3;
    Passenger passenger4;
    CabinCrewMember cabinCrewMember;

    ArrayList<CabinCrewMember> cabinCrew;
    Set<Integer> assignedSeats;


    @Before
    public void before() {
        cabinCrew = new ArrayList<>();
        pilot = new Pilot("John", Rank.CAPTAIN, "Pilot123");
        plane = Plane.AIRBUSA380;
        passenger = new Passenger("Bob", 2);
        passenger2 = new Passenger("Jane", 1);
        passenger3 = new Passenger("Jim", 3);
        passenger4 = new Passenger("Jill", 2);
        cabinCrewMember = new CabinCrewMember("Jane", Rank.FLIGHT_ATTENDANT);
        flight = new Flight(pilot, "FR756", "EDI", "GLA", Date.from(Instant.parse("2023-08-22T18:12:42.00Z")), cabinCrew, plane, assignedSeats);
    }

    @Test
    public void canGetPilot() {
        assertEquals("John", flight.getPilot().getName());

    }

    @Test
    public void canGetFlightNumber() {
        assertEquals("FR756", flight.getFlightNumber());
    }

    @Test
    public void canGetDestination() {
        assertEquals("EDI", flight.getDestination());
    }

    @Test
    public void canGetDepartureAirport() {
        assertEquals("GLA", flight.getDepartureAirport());
    }

    @Test
    public void canGetDepartureTime() {
        assertEquals("Tue Aug 22 19:12:42 BST 2023", flight.getDepartureTime().toString());
    }

    @Test
    public void canGetNumberOfAvailableSeats() {
        assertEquals(4, flight.getNumberOfAvailableSeats());
    }

    @Test
    public void canBookPassenger() {
        flight.bookPassenger(passenger);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);
        flight.bookPassenger(passenger4);
        assertEquals(521, flight.getNumberOfAvailableSeats());
        assertEquals(4, flight.getAssignedSeats().size());
    }

    @Test
    public void canGetPlane() {
        assertEquals("Cessna 172", flight.getPlaneName());
    }

    @Test
    public void canGetPassengers() {
        flight.bookPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
    }
}