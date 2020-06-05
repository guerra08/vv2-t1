package br.com.guerra08.app.model;

import br.com.guerra08.app.helpers.Formatting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Furniture extends Resource{

    protected Furniture(){}

    /**
     * Constructor for Furniture
     * @param name Name
     * @param unitCost Unit cost (per day)
     * @param category Category (table, board...)
     */
    public Furniture(String name, double unitCost, String category) {
        super(name, unitCost, category);
    }

    @Override
    public String toString(){
        return String.format("Id: %s - Nome: %s - Custo diário: %s - Tipo: %s", this.getId(), this.getName(), Formatting.valueToCurrencyString(this.getUnitCost()), "Mobília");
    }
}
