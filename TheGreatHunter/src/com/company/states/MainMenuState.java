package com.company.states;

import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.utils.Constants;

public class MainMenuState extends State {
	
	public static Button playButton = new Button(140, 340, Assets.playButton);
	public static Button scoresButton = new Button(140, 420, Assets.scoresButton);
    public static Button exitButton = new Button(140, 500, Assets.exitButton);

	public MainMenuState() {
	}
	
	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.mainMenuBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        playButton.display(graphics);
        exitButton.display(graphics);
        scoresButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
