package models;

public class Furniture extends Resource{

    /**
     * Constructor for Furniture
     * @param id Resource id
     * @param name Name
     * @param unitCost Unit cost (per day)
     * @param type Type (table, board...)
     */
    public Furniture(String id, String name, double unitCost, String type) {
        super(id, name, unitCost, type);
    }
}
