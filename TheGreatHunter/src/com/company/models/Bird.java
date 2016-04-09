package com.company.models;

import com.company.enums.SecondaryResourceType;

import java.awt.image.BufferedImage;

public class Bird extends Prey {

	// TODO: ADD type.Feather
	public Bird(int x, int y, BufferedImage gameObjectImage, double weight, double meatPercentage) {
		super(x, y, gameObjectImage, weight, meatPercentage, SecondaryResourceType.FEATHER);
	}
}
