package models;

import java.util.UUID;

public abstract class Resource {

    private String id;
    private String name;
    private double unitCost;
    private String type;

    /**
     * Constructor for Resource
     * @param name Name of the resource
     * @param unitCost Unit cost (per day)
     * @param type Type of the resource
     */
    public Resource(String id, String name, double unitCost, String type) {
        this.id = id;
        this.name = name;
        this.unitCost = unitCost;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getType() { return type; }

    public void setType(String type) { this.type = type; }

    @Override
    public String toString(){
        return String.format("Resource: %s -  Id: %s - Name: %s - Unit cost: %f - Type: %s", this.getClass().getSimpleName(), this.id, this.name, this.unitCost, this.type);
    }
}
