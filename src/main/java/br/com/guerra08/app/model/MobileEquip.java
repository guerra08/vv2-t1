package br.com.guerra08.app.model;

import br.com.guerra08.app.helpers.Formatting;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class MobileEquip extends Resource{

    protected MobileEquip(){}

    /**
     * Constructor for MobileEquip
     * @param name Name
     * @param unitCost Unit cost (per day)
     * @param category Type (phone, computer...)
     */
    public MobileEquip(String name, double unitCost, String category) {
        super(name, unitCost, category);
    }

    @Override
    public String toString(){
        return String.format("Id: %s - Nome: %s - Custo diário: %s - Tipo: %s", this.getId(), this.getName(), Formatting.valueToCurrencyString(this.getUnitCost()), "Equipamento móvel");
    }
}
