package com.company.models;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.company.interfaces.Displayable;
import com.company.interfaces.Updateable;

public abstract class GameObject implements Displayable, Updateable {
	private int x;
    private int y;
    private BufferedImage gameObjectImage;
    
	public GameObject(int x, int y, BufferedImage gameObjectImage) {
		this.x = x;
		this.y = y;
		this.gameObjectImage = gameObjectImage;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public BufferedImage getGameObjectImage() {
		return gameObjectImage;
	}

	public void setGameObjectImage(BufferedImage gameObjectImage) {
		this.gameObjectImage = gameObjectImage;
	}
    

	public void display(Graphics graphics) {
		graphics.drawImage(this.getGameObjectImage(), this.getX(), this.getY(), null);
	}

	public void update() {}
}
