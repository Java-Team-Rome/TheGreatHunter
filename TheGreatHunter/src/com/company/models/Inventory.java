package com.company.models;


import com.company.enums.SecondaryResourceType;

import java.util.function.Consumer;

public class Inventory implements Consumer<Prey> {

    private double meat;
    private double feather;
    private double leather;

    public double getMeat() {
        return meat;
    }

    public void setMeat(int meat) {
        this.meat = meat;
    }

    public double getFeather() {
        return feather;
    }

    public void setFeather(int feather) {
        this.feather = feather;
    }

    public double getLeather() {
        return leather;
    }

    public void setLeather(int leather) {
        this.leather = leather;
    }


    @Override
    public void accept(Prey prey) {
        this.meat += prey.getWeight() * prey.getMeatPercentage();

        if (prey.getSecondaryResourceType.equals(SecondaryResourceType.LEATHER)){
            leather += prey.getWeight() * ( 1 - prey.getMeatPercentage);
        }

        else if (prey.getSecondaryResourceType.equals(SecondaryResourceType.FEATHER)){
            feather += prey.getWeight() * ( 1 - prey.getMeatPercentage);
        }
    }
}









