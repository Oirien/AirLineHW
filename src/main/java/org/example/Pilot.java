package org.example;

public class Pilot {
    String name;
    Rank rank;
    String licenceNumber;

    public Pilot(String name, Rank rank, String licenceNumber) {
        this.name = name;
        this.rank = rank;
        this.licenceNumber = licenceNumber;
    }
    public String flyPlane() {
        return "I am flying the plane!";
    }

    public String getName() {
        return this.name;
    }
}
