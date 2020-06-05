package br.com.guerra08.app.model;

import br.com.guerra08.app.constant.CSpaces;
import br.com.guerra08.app.helpers.Formatting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("3")
public class Spaces extends Resource{

    protected Spaces(){}

    private double squareMeters;
    private int capacity;

    /**
     * Constructor for Space
     * @param name Name
     * @param sqm Size in m²
     * @param cap Capacity of the space
     * @param category The category
     */
    public Spaces(String name, double sqm, int cap, String category) {
        super(name, (sqm * CSpaces.PRICE_PER_SQUARE) + (cap * CSpaces.PRICE_PER_SEAT), category);
        this.squareMeters = sqm;
        this.capacity = cap;
    }

    public double getSquareMeters() { return squareMeters; }

    public void setSquareMeters(double squareMeters) { this.squareMeters = squareMeters; }

    public int getCapacity() { return capacity; }

    public void setCapacity(int capacity) { this.capacity = capacity; }

    @Override
    public String toString(){
        return String.format("Id: %s - Nome: %s - Custo diário: %s - Tipo: %s - Capacidade: %d - M²: %f", this.getId(), this.getName(), Formatting.valueToCurrencyString(this.getUnitCost()), "Espaço físico", this.capacity, this.squareMeters);
    }
}
