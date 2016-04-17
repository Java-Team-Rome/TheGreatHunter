package com.company.states;

import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.utils.Constants;

public class MarketState extends State {

	public static Button sellButton = new Button(570, 530, Assets.sellButton);

	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.marketBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
		
        sellButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
