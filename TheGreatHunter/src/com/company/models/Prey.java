package com.company.models;

import java.awt.image.BufferedImage;

public abstract class Prey extends GameObject {
	
	private double weight;
	
	private double meatPercentage;

	public Prey(int x, int y, BufferedImage gameObjectImage, double weight, double meatPercentage) {
		super(x, y, gameObjectImage);
		this.weight = weight;
		this.meatPercentage = meatPercentage;
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
}
