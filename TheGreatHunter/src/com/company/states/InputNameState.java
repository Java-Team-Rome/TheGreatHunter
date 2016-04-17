package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;

public class InputNameState extends State {

	public static Button okButton = new Button(650, 450, "OK", Assets.button);
    public static StringBuilder sb = new StringBuilder();
    
    @Override
    public void display(Graphics graphics) {

        graphics.drawImage(Assets.background, 0, 0, null);

        Font titleFont = new Font("Comic Sans MS", Font.BOLD, 40);
        graphics.setFont(titleFont);
        graphics.setColor(Color.green);
        graphics.drawString("INPUT NAME", 30, 100);

        Font buttonsFont = new Font("Comic Sans MS", Font.BOLD, 20);
        graphics.setFont(buttonsFont);
        graphics.setColor(Color.white);


        graphics.drawString("Please enter your name:", 190,350);
        graphics.drawRect(260,370,280,40);
        graphics.drawString(sb.toString(),265,395);

        okButton.display(graphics);
    }

    @Override
    public void update() {
    }
}
