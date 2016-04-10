package com.company.models;

import com.company.enums.SecondaryResourceType;

import java.awt.image.BufferedImage;

public abstract class Prey extends GameObject {
	
	private double weight;
	private SecondaryResourceType secondaryResourceType;
	private double meatPercentage;
	public SecondaryResourceType getSecondaryResourceType;
	public Object getWeight;
	public double getMeatPercentage;

	public Prey(int x, int y, BufferedImage gameObjectImage, double weight, double meatPercentage,SecondaryResourceType secondaryResourceType) {
		super(x, y, gameObjectImage);
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
	public SecondaryResourceType getSecondaryResourceType (SecondaryResourceType secondaryResourceType) {
		return this.secondaryResourceType = secondaryResourceType;
	}
}
