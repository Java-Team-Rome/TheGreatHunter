package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.utils.Constants;

public class InputNameState extends State {

	public static Button okButton = new Button(650, 450, "OK", Assets.button);
    public static StringBuilder sb = new StringBuilder();
    
    @Override
    public void display(Graphics graphics) {
        graphics.drawImage(Assets.woodenWall, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

        Font textFont = new Font("Comic Sans MS", Font.ITALIC, 20);
        graphics.setFont(textFont);
        graphics.setColor(Color.black);
                
        graphics.drawImage(Assets.stickyNote, 350, 250, null);
        graphics.drawString("Enter your name:", 380, 320);
        
        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(buttonsFont);
        graphics.drawString(sb.toString(), 380, 370);

        okButton.display(graphics);
    }

    @Override
    public void update() {
    }
}
