package com.company.models;

import com.company.enums.SecondaryResourceType;

public class Inventory {

    private static double meat;
    private static double feather;
    private static double leather;

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


    interface Consumer<Prey>{

        this.meat += prey.getWeith * prey.getMeatPercentage;

        if (prey.getSecondoryresourceType.equals(SecondaryResourceType.LEATHER){
            leather += prey.getWeight * ( 1 - prey.getMeatPercentage);
        }

        else if (prey.getSecondoryresourceType.equals(SecondaryResourceType.FEATHER){
            feather += prey.getWeight * ( 1 - prey.getMeatPercentage);
        }



    }

}








}
