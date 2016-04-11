package com.company.models.prey;

import com.company.enums.SecondaryResourceType;
import com.company.graphics.SpriteSheet;

public class Bird extends Prey {

	public Bird(int x, int y, SpriteSheet spriteSheet, 
			int width, int height, 
			double weight, double meatPercentage) {
		super(x, y, spriteSheet, width, 
				height, weight, 
				meatPercentage, SecondaryResourceType.FEATHER);
	}
}
