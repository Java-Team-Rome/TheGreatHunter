package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;

public class MainMenuState extends State {
	
	public static Button playButton = new Button(650, 450, "PLAY", Assets.button);
    public static Button exitButton = new Button(650, 520, "EXIT", Assets.button);

	public MainMenuState() {
	}
	
	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.background, 0, 0, null);

        Font titleFont = new Font("Comic Sans MS", Font.BOLD, 40);
        graphics.setFont(titleFont);
        graphics.setColor(Color.green);
        graphics.drawString("The Great Hunter!", 30, 100);

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
