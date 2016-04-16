package com.company.states;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.company.game.MapInitializer;
import com.company.graphics.Assets;
import com.company.models.prey.Prey;

public class GameState extends State {

	private Prey prey;
	private int timer;
	private int seconds = 30;
	private String secondsPrint;

	public GameState() {
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
		graphics.drawString(secondsPrint, 750, 50);

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
		if (seconds == 0) {
			System.exit(1);
		}
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		secondsPrint = Integer.toString(seconds);
	}

}
