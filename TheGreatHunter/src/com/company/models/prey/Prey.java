package com.company.models.prey;

import com.company.enums.SecondaryResourceType;
import com.company.graphics.SpriteSheet;
import com.company.models.GameObject;

public abstract class Prey extends GameObject {
	
	private double weight;
	private SecondaryResourceType secondaryResourceType;
	private double meatPercentage;


	public Prey(int x, int y, SpriteSheet spriteSheet, 
			int width, int height, double weight, 
			double meatPercentage, 
			SecondaryResourceType secondaryResourceType) {
		super(x, y, spriteSheet, width, height);
		this.weight = weight;
		this.meatPercentage = meatPercentage;
		this.secondaryResourceType = secondaryResourceType;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getMeatPercentage() {
		return meatPercentage;
	}

	public void setMeatPercentage(double meatPercentage) {
		this.meatPercentage = meatPercentage;
	}

	public SecondaryResourceType getSecondaryResourceType() {
		return secondaryResourceType;
	}
	
}
