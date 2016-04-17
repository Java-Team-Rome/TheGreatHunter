package com.company.states;

import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.utils.Constants;

public class HighScoresState extends State {

	public static Button menuButton = new Button(570, 530, Assets.menuButton);

	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.highscoresBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
		
        menuButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
