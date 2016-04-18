package com.company.states;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import com.company.graphics.Assets;
import com.company.models.Button;
import com.company.models.HunterScore;
import com.company.utils.Constants;
import com.company.utils.HighScores;

public class HighScoresState extends State {

	public static Button menuButton = new Button(570, 530, Assets.menuButton);

	@Override
	public void display(Graphics graphics) {
		int y = 250;
		HighScores.load();
		LinkedHashMap<String,HunterScore> sorted = HighScores.getScores()
				.entrySet()
				.stream()
				.sorted(Comparator.comparing(Map.Entry::getValue))
				.limit(10)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(e1, e2) -> e1, LinkedHashMap::new));

		graphics.drawImage(Assets.highScoresBackground, 0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT, null);
		graphics.drawImage(Assets.scoreList, 300, 120, null);
		graphics.drawImage(Assets.trophy, 180, 220, null);

		Font font = new Font("Comic Sans MS", Font.BOLD, 17);
		graphics.setFont(font);
		graphics.setColor(Color.black);


		for (Map.Entry<String, HunterScore> score : sorted.entrySet()) {
			graphics.drawString(score.getKey(),450,y);
			graphics.drawString(String.valueOf(score.getValue().getAmountOfPreyKilled()), 550, y);
			graphics.drawString(score.getValue().getGold().toString(),665,y);
			y +=20;
		}

        menuButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
