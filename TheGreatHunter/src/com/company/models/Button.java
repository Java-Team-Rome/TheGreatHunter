package com.company.models;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Button extends GameObject {

    Rectangle colliderBox;
    BufferedImage gameObjectIcon;

    public Button(int x, int y, BufferedImage gameObjectIcon ) {
		super(x, y);
		this.gameObjectIcon = gameObjectIcon;
		this.colliderBox = new Rectangle(this.getX(), this.getY(),
                this.gameObjectIcon.getWidth(), this.gameObjectIcon.getHeight());
	}
  
    public Rectangle getColliderBox() {
		return colliderBox;
	}

	@Override
	public void update() {
    }

    @Override
    public void display(Graphics graphics) {
    	graphics.drawImage(this.gameObjectIcon, this.getX(), this.getY(), null);
    }
}

