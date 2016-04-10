package com.company.models;


import java.util.function.Consumer;

public class Market implements Consumer<Hunter> {

    private final double PRICE_MEAT_PER_UNIT = 20;
    private final double PRICE_LEATHER_PER_UNIT = 40;
    private final double PRICE_FEATHER_PER_UNIT = 10;

    private double priceMeatPerUnit;
    private double priceLeatherPerUnit;
    private double priceFeatherPerUnit;

    private static Market instance;

    private Market(double priceMeatPerUnit, double priceLeatherPerUnit, double priceFeatherPerUnit) {
        this.priceMeatPerUnit = PRICE_MEAT_PER_UNIT;
        this.priceLeatherPerUnit = PRICE_LEATHER_PER_UNIT;
        this.priceFeatherPerUnit = PRICE_FEATHER_PER_UNIT;
    }

    public static Market getInstance() {
        if (instance == null) {
            instance = new Market(PRICE_MEAT_PER_UNIT, PRICE_LEATHER_PER_UNIT, PRICE_FEATHER_PER_UNIT);
            return instance;
        }

        return instance;
    }

    @Override
    public void accept(Hunter hunter) {
        hunter.setGold(this.evaluate(hunter.getInventory()));
    }

    public double evaluate(Inventory inventory) {
        double total = 0;

        total += inventory.getMeat() * priceMeatPerUnit;
        inventory.setMeat(0);

        total += inventory.getFeather() * priceFeatherPerUnit;
        inventory.setFeather(0);

        total += inventory.getLeather() * priceLeatherPerUnit;
        inventory.setLeather(0);

        return total;
    }
}
