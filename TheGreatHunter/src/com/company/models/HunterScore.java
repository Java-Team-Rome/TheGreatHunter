package com.company.models;


public class HunterScore  {

    private int AmountOfPreyKilled;
    private Double Gold;

    public HunterScore(Double gold,int amountOfPreyKilled) {
        this.AmountOfPreyKilled = amountOfPreyKilled;
        this.Gold = gold;
    }

    public int getAmountOfPreyKilled() {
        return AmountOfPreyKilled;
    }

    public Double getGold() {
        return Gold;
    }
}
