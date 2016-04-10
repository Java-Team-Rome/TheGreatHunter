package com.company.models;

import com.company.interfaces.Killer;

public class Hunter implements Killer{
	private final Inventory inventory = new Inventory();
	private double gold;

	@Override
	public void kill(Prey prey) {
		// TODO Auto-generated method stub
		
	}

	public double getGold() {
		return gold;
	}

	public void setGold(double gold) {
		this.gold = gold;
	}

	public Inventory getInventory() {
		return inventory;
	}

}
