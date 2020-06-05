package br.com.guerra08.app.model;

import javax.persistence.*;

@Entity
@Inheritance
@Table(name = Resource.TABLE_NAME)
@DiscriminatorColumn(name = Resource.DISCRIMINATOR_COLUMN)
public abstract class Resource {

    public static final String TABLE_NAME= "RESOURCES";
    public static final String DISCRIMINATOR_COLUMN= "TYPE";

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double unitCost;
    private String category;

    protected Resource() {}

    /**
     * Constructor for Resource
     * @param name Name of the resource
     * @param unitCost Unit cost (per day)
     * @param category Type of the resource
     */
    public Resource(String name, double unitCost, String category) {
        this.name = name;
        this.unitCost = unitCost;
        this.category = category;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

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

    public String getCategory(){ return category; }

    public void setCategory(String category) { this.category = category; }
}
