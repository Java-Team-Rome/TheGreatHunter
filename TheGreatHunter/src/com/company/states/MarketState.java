package com.company.states;

import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.models.Hunter;
import com.company.utils.Constants;

public class MarketState extends State {

	private Hunter currentHunter;
	public static Button sellButton = new Button(570, 530, Assets.sellButton);
	
	public MarketState(Hunter hunter) {
		this.currentHunter = hunter;
	}
	
	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.marketBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
		graphics.drawImage(Assets.receipt, 460, 170, null);
		graphics.drawImage(Assets.gold, 380, 380, null);
		
		//DRAW LIST OF INVENTIRY HERE:
		
        sellButton.display(graphics);
	}

	@Override
	public void update() {
	}
	
	public Hunter getCurrentHunter() {
		return this.currentHunter;
	}
}
