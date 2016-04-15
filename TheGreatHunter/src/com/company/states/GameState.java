package com.company.states;

import java.awt.Graphics;

import com.company.game.MapInitializer;
import com.company.graphics.Assets;
import com.company.models.prey.Prey;

public class GameState extends State {

	private Prey prey;
    private int timer;
    
    public GameState() {
    	prey = MapInitializer.generatePray();
	}
    
	@Override
	public void display(Graphics graphics) {
		graphics.drawImage(Assets.background, 0, 0, 800, 600, null);
		
		if (prey.isAlive() && !prey.isHasEscaped()) {
    		prey.display(graphics);
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
	}
}
