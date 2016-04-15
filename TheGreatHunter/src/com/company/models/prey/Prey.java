package com.company.models.prey;

import java.awt.Graphics;

import com.company.enums.SecondaryResourceType;
import com.company.graphics.SpriteSheet;
import com.company.models.GameObject;

public abstract class Prey extends GameObject {
	
	private double weight;
	private SecondaryResourceType secondaryResourceType;
	private double meatPercentage;
	private boolean isAlive;
	private int speed;
    private int width;
    private int height;
    SpriteSheet spriteSheet;
    private boolean hasEscaped;

	public Prey(int x, int y, SpriteSheet spriteSheet, int width, int height, double weight, double meatPercentage, 
			SecondaryResourceType secondaryResourceType) {
		super(x, y);
		this.width = width;
		this.height = height;
		this.weight = weight;
		this.meatPercentage = meatPercentage;
		this.secondaryResourceType = secondaryResourceType;
		this.isAlive = true;
		this.spriteSheet = spriteSheet;
		this.hasEscaped = false;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getMeatPercentage() {
		return meatPercentage;
	}

	public void setMeatPercentage(double meatPercentage) {
		this.meatPercentage = meatPercentage;
	}

	public SecondaryResourceType getSecondaryResourceType() {
		return secondaryResourceType;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public boolean isHasEscaped() {
		return hasEscaped;
	}

	public void setHasEscaped(boolean hasEscaped) {
		this.hasEscaped = hasEscaped;
	}

	@Override
	public void display(Graphics graphics) {
		if (!hasEscaped && isAlive) {
			graphics.drawImage(this.spriteSheet.crop(speed * width, 0, width, height), this.getX(), this.getY(), null);
		}
	}

	@Override
	public void update() {
		System.out.println(speed);
		speed++;
		speed %= 3;
		this.setX(getX() + 20);
	}
}
