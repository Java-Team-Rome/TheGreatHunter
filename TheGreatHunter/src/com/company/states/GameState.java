package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import com.company.game.MapInitializer;
import com.company.graphics.Assets;
import com.company.models.Hunter;
import com.company.models.prey.Prey;

public class GameState extends State {

	private Prey prey;
	private int timer;
	private int seconds = 90;
	private Hunter hunter;
	private Point mousePosition;

	public GameState(String playerName) {
		hunter = new Hunter(playerName);
		prey = MapInitializer.generatePray();
	}

	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.background, 0, 0, 800, 600, null);

		if (prey.isAlive() && !prey.isHasEscaped()) {
			prey.display(graphics);
		}

		Font secondsFont = new Font("Comic Sans MS", Font.BOLD, 30);
		graphics.setFont(secondsFont);
		graphics.setColor(Color.white);
		graphics.drawString(Integer.toString(seconds), 750, 50);
		graphics.drawString(Integer.toString(this.hunter.getAmountOfPreyKilled()), 50, 50);
		
		if (mousePosition != null) {
			graphics.drawImage(Assets.sight, mousePosition.x, mousePosition.y, null);
		}
	}

	@Override
	public void update() {	
		timer++;
		if (timer == 3) {
			prey.isHasEscaped();
			prey = MapInitializer.generatePray();
			timer = 0;
		}

		prey.update();
		
		seconds--;
		if (seconds < 0) {
			System.exit(1);
		}			
	}
	
	public Prey getCurrentPrey() {
		return this.prey;
	}
	
	public void killPrey(Prey currentPrey) {
		this.hunter.kill(currentPrey);
		this.hunter.setAmountOfPreyKilled(this.hunter.getAmountOfPreyKilled() + 1);
	}
	
	public void setMousePosition(int x, int y) {
		this.mousePosition = new Point(x, y);
	}
}
