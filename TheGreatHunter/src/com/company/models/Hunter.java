package com.company.models;

import com.company.interfaces.Killer;
import com.company.interfaces.Trader;
import com.company.models.prey.Prey;

public class Hunter implements Killer, Trader {
	
	private final Inventory inventory;
	private String name;
	private double gold;
	private int amountOfPreyKilled;

	public Hunter(String name) {
		this.name = name;
		inventory = new Inventory();
	}

	public String getName() {
		return name;
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}
	public void setAmountOfPreyKilled(int amountOfPreyKilled) {
		this.amountOfPreyKilled = amountOfPreyKilled;
	}
	public int getAmountOfPreyKilled() {
		return amountOfPreyKilled;
	}

	public Inventory getInventory() {
		return inventory;
	}
	
	@Override
	public void kill(Prey prey) {
		if (prey.isAlive()) {
			inventory.accept(prey);
			prey.setAlive(false);
			this.amountOfPreyKilled++;
		}
		
	}
	
	public void sell() {
		Market.getInstance().accept(this);
	}
}
