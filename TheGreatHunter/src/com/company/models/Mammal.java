package com.company.models;

import com.company.enums.SecondaryResourceType;

import java.awt.image.BufferedImage;

public class Mammal extends Prey {

	// ADD type.Leather
	public Mammal(int x, int y, BufferedImage gameObjectImage, double weight, double meatPercentage) {
		super(x, y, gameObjectImage, weight, meatPercentage, SecondaryResourceType.LEATHER);
	}
}
