package com.company.models;


public class HunterScore implements Comparable<HunterScore>  {

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

    @Override
    public int compareTo(HunterScore other) {
        if (this.AmountOfPreyKilled > other.getAmountOfPreyKilled()) {
            return -1;
        } else if (this.AmountOfPreyKilled < other.getAmountOfPreyKilled()) {
            return 1;
        } else if (this.Gold < other.getGold()) {
            return 1;
        } else if (this.Gold > other.getGold()) {
            return -1;
        } else return 0;
    }
}
