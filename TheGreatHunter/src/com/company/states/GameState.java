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
	private int seconds = 30;
	private Hunter hunter;
	private Point mousePosition;
	private long timerSeconds = System.nanoTime();
	private long timerNextPreyDelay = System.nanoTime();
	private long timerUpdateDelay = System.nanoTime();

	private long timeDelay = 1000;
	private long nextPreyDelay = 800;
	private long updateDelay = 50;


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

		Font secondsFont = new Font("Comic Sans MS", Font.BOLD, 17);
		graphics.setFont(secondsFont);
		graphics.setColor(Color.white);

		graphics.drawString(Integer.toString(seconds), 960, 30);

		graphics.drawString(String.format("%d", this.hunter.getAmountOfPreyKilled()), 60, 30);
		graphics.drawString(String.format("%.2f kg.", this.hunter.getInventory().getMeat()), 210, 30);
		graphics.drawString(String.format("%.2f kg.", this.hunter.getInventory().getLeather()), 340, 30);
		graphics.drawString(String.format("%.2f kg.", this.hunter.getInventory().getFeather()), 500, 30);

		if (mousePosition != null) {
			graphics.drawImage(Assets.sight, mousePosition.x, mousePosition.y, null);
		}
	}

	@Override
	public void update() {
		long elapsedNextPrey = (System.nanoTime() - this.timerNextPreyDelay) / 1000000;
		long elapsedSeconds = (System.nanoTime() - this.timerSeconds) / 1000000;
		long elapsedUpdate = (System.nanoTime() - this.timerUpdateDelay) / 1000000;

		if (elapsedNextPrey > this.nextPreyDelay) {
			prey.isHasEscaped();
			prey = MapInitializer.generatePray();
			timerNextPreyDelay = System.nanoTime();
		}

		if (elapsedUpdate > this.updateDelay) {
			prey.update();
			timerUpdateDelay = System.nanoTime();
		}

		if(elapsedSeconds > this.timeDelay) {
			seconds--;
			timerSeconds = System.nanoTime();
		}

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
