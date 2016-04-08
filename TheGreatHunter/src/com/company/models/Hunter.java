package com.company.models;

import com.company.interfaces.Killer;

public class Hunter implements Killer{
	private final Inventory inventory = new Inventory();

	@Override
	public void kill(Prey prey) {
		// TODO Auto-generated method stub
		
	}

	public Inventory getInventory() {
		return inventory;
	}
}
