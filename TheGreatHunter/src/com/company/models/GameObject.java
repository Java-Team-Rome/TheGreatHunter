package com.company.models;

import java.awt.Graphics;

import com.company.graphics.SpriteSheet;
import com.company.interfaces.Displayable;
import com.company.interfaces.Updateable;

// TODO change spriteSheet to bufferImage
public abstract class GameObject implements Displayable, Updateable {
	private int x;
    private int y;
    private SpriteSheet spriteSheet;
    private int width;
    private int height;
    private int col;
    
	public GameObject(int x, int y, SpriteSheet spriteSheet, int width, int height) {
		this.x = x;
		this.y = y;
		this.spriteSheet = spriteSheet;
		this.width = width;
		this.height = height;
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

	public SpriteSheet getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(SpriteSheet spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	public void display(Graphics graphics) {
		graphics.drawImage(this.spriteSheet.crop(col*width, 0, width, height), this.getX(), this.getY(), null);
	}

	public void update() {
		col++;
		col %= 3;
		this.x += 20;
	}
}
