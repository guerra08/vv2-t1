package br.com.guerra08.app.model;

import br.com.guerra08.app.helpers.Formatting;

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

    @Override
    public String toString(){
        return String.format("Id: %s - Nome: %s - Custo diário: %s - Tipo: %s", this.getId(), this.getName(), Formatting.valueToCurrencyString(this.getUnitCost()), "Mobília");
    }
}
