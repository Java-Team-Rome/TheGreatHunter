package com.company.states;

import java.awt.Graphics;
import java.util.Map;
import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.models.HunterScore;
import com.company.utils.HighScores;

public class HighScoresState extends State {

	public static Button menuButton = new Button(570, 530, Assets.menuButton);
	private int y = 250;

	@Override
	public void display(Graphics graphics) {
		HighScores.load();
		graphics.drawImage(Assets.scoreList, 300, 120, null);
		graphics.drawImage(Assets.trophy, 180, 220, null);
		for (Map.Entry<String, HunterScore>  score : HighScores.getScores().entrySet() ) {
			graphics.drawString(score.getKey(),450,y);
			graphics.drawString(String.valueOf(score.getValue().getAmountOfPreyKilled()), 550, y);
			graphics.drawString(score.getValue().getGold().toString(),665,y);
			y +=20;
		}
		y = 250;
        menuButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
