package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.utils.Constants;

public class InputNameState extends State {

	public static Button enterButton = new Button(420, 530, Assets.enterButton);
    public static StringBuilder stringBuilger = new StringBuilder();
    
    @Override
    public void display(Graphics graphics) {
        graphics.drawImage(Assets.woodenBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.black);
                
        graphics.drawImage(Assets.stickyNote, 350, 250, null);
        graphics.drawString("Enter your name:", 380, 320);
        
        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(buttonsFont);
        graphics.drawString(stringBuilger.toString(), 400, 370);

        enterButton.display(graphics);
    }

    @Override
    public void update() {
    }
}
