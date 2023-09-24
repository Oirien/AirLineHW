package org.example;

public enum Plane {
    BOEING747(400, 1600, "Boeing 747"),
    AIRBUSA380(525, 2100, "Airbus A380"),
    CESSNA172(4, 16, "Cessna 172"),
    F4_PHANTOM(2, 4, "F4 Phantom"),
    F16_FALCON(1, 2, "F16 Falcon");

    private final int capacity;
    private final int totalWeight;

    private final String name;

    Plane(int capacity, int totalWeight, String name) {
        this.capacity = capacity;
        this.totalWeight = totalWeight;
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public String getName() {
        return name;
    }
}
