package models;

import constants.CSpaces;

public class Spaces extends Resource{

    private double squareMeters;
    private int capacity;

    /**
     * Constructor for Space
     * @param id Resource id
     * @param name Name
     * @param type Space type (room, venue...)
     * @param sqm Size in m²
     * @param cap Capacity of the space
     */
    public Spaces(String id, String name, String type, double sqm, int cap) {
        super(id, name, (sqm * CSpaces.PRICE_PER_SQUARE) + (cap * CSpaces.PRICE_PER_SEAT), type);
        this.squareMeters = sqm;
        this.capacity = cap;
    }

    public double getSquareMeters() { return squareMeters; }

    public void setSquareMeters(double squareMeters) { this.squareMeters = squareMeters; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String toString(){
        return super.toString().concat(String.format(" - Capacity: %d - M²: %f", this.capacity, this.squareMeters));
    }
}
