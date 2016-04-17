package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;

import com.company.game.MapInitializer;
import com.company.graphics.Assets;
import com.company.models.Hunter;
import com.company.models.prey.Prey;
import com.company.utils.Constants;

public class GameState extends State {

	private Prey prey;
	private int timer;
	private int seconds = 30;
	private Hunter hunter;
	private Point mousePosition;

	public GameState(String playerName) {
		hunter = new Hunter(playerName);
		prey = MapInitializer.generatePray();
	}

	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.gameBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);

		if (prey.isAlive() && !prey.isHasEscaped()) {
			prey.display(graphics);
		}

		Font secondsFont = new Font("Comic Sans MS", Font.BOLD, 30);
		graphics.setFont(secondsFont);
		graphics.setColor(Color.white);
		graphics.drawString(Integer.toString(seconds), 960, 40);
		graphics.drawString(Integer.toString(this.hunter.getAmountOfPreyKilled()), 20, 40);
		
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
			 StateManager.setCurrentState(new MarketState(this.hunter));
		}			
	}
	
	public Prey getCurrentPrey() {
		return this.prey;
	}
	
	public Hunter getHunter() {
		return this.hunter;
	}
	
	public void setMousePosition(int x, int y) {
		this.mousePosition = new Point(x, y);
	}
}
