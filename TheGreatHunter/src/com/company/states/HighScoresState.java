package com.company.states;

import java.awt.*;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
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
		int yCoord = 250;
		
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

		Font font = new Font("Comic Sans MS", Font.BOLD, 16);
		graphics.setFont(font);
		graphics.setColor(Color.black);


		for (Map.Entry<String, HunterScore> score : sorted.entrySet()) {
			graphics.drawString(score.getKey(), 410, yCoord);
			graphics.drawString(Integer.toString(score.getValue().getAmountOfPreyKilled()), 580, yCoord);
			graphics.drawString(String.format("%.2f", score.getValue().getGold()), 670, yCoord);
			yCoord += 20;
		}

        menuButton.display(graphics);
	}

	@Override
	public void update() {
	}
}
