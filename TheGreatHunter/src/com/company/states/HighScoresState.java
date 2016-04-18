package com.company.states;

import java.awt.Graphics;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.models.HunterScore;
import com.company.utils.Constants;
import com.company.utils.HighScores;

public class HighScoresState extends State {

	public static Button menuButton = new Button(570, 530, Assets.menuButton);
	private int x = 500;
	private int y = 250;

	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.highscoresBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
		
		graphics.drawImage(Assets.scoreList, 300, 120, null);
		graphics.drawImage(Assets.trophy, 180, 220, null);
		HighScores.load();
		for (String treeKey : HighScores.getScores().keySet() ) {
			graphics.drawString(treeKey,x,y);
			y +=20;
		}
		x = 550;
		y = 250;
		for (HunterScore preyKilled : HighScores.getScores().values()) {
			graphics.drawString(String.valueOf(preyKilled.getAmountOfPreyKilled()), x, y);
			y +=20;
		}
		x = 665;
		y = 250;
		for (HunterScore gold : HighScores.getScores().values()) {
			graphics.drawString(gold.getGold().toString(),x,y);
			y +=20;
		}
		x = 450;
		y = 250;


		
        menuButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
