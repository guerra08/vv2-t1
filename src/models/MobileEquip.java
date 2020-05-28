package models;

public class MobileEquip extends Resource{

    /**
     * Constructor for MobileEquip
     * @param name Name
     * @param unitCost Unit cost (per day)
     * @param type Type (phone, computer...)
     */
    public MobileEquip(String name, double unitCost, String type) {
        super(name, unitCost, type);
    }
}
