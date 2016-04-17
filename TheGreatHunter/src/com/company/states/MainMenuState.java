package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.utils.Constants;

public class MainMenuState extends State {
	
	public static Button playButton = new Button(840, 420, "PLAY", Assets.button);
    public static Button exitButton = new Button(840, 500, "EXIT", Assets.button);

	public MainMenuState() {
	}
	
	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.woodenWall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font titleFont = new Font("Comic Sans MS", Font.BOLD, 40);
        graphics.setFont(titleFont);
        graphics.setColor(Color.green);
        graphics.drawString("The Great Hunter!", 390, 100);

        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(buttonsFont);
        graphics.setColor(Color.black);
        
        playButton.display(graphics);
        exitButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
