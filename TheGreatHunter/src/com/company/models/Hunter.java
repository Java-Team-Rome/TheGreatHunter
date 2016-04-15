package com.company.models;

import com.company.interfaces.Killer;
import com.company.models.prey.Prey;

public class Hunter implements Killer{
	private final Inventory inventory;
	private String name;
	private double gold;
	private int amountOfPreyKilled;

	public Hunter() {
		inventory = new Inventory();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
		inventory.accept(prey);
	}
	
	public void sell() {
		Market.getInstance().accept(this);
	}

}
