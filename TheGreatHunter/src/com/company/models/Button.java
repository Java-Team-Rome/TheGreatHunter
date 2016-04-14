package com.company.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.company.interfaces.Displayable;

public class Button extends GameObject implements Displayable {

    public String name;
    Rectangle rectangle;
    BufferedImage gameObjectIcon;

    public Button(int x, int y, String name, BufferedImage gameObjectIcon ) {
		super(x, y, null, 0, 0);
		this.name = name;
		this.gameObjectIcon = gameObjectIcon;
		this.rectangle = new Rectangle(this.getX(), this.getY(),
                this.gameObjectIcon.getWidth(), this.gameObjectIcon.getHeight());
	}

    @Override
	public void update() {
    }

    @Override
    public void display(Graphics graphics) {
    	graphics.drawImage(this.gameObjectIcon, this.getX(), this.getY(), null);
    	graphics.drawString(name, this.getX() + 35, this.getY() + 22);
    }
}

