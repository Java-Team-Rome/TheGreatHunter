package com.company.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.company.graphics.Display;
import com.company.states.GameState;
import com.company.states.MainMenuState;
import com.company.states.StateManager;

public class MouseInput implements MouseListener {

	    public MouseInput(Display display) {
	        display.getCanvas().addMouseListener(this);
	    }

	    @Override
	    public void mouseClicked(MouseEvent e) {
	    }

	    public void mousePressed(MouseEvent e) {

	        int mouseX = e.getX();
	        int mouseY = e.getY();

	        if(StateManager.getCurrentState() instanceof MainMenuState) {
	            //Play Button
	            if(MainMenuState.playButton.getColliderBox().contains(mouseX, mouseY)){
	                StateManager.setCurrentState(new GameState());
	            }

	            //High Scores Button
//	            if (MainMenuState.highScoreButton.getColliderBox().contains(mouseX, mouseY)) {
//	                StateManager.setCurrentState(new HighScoresState());
//	            }

	            //Exit Button
	            if (MainMenuState.exitButton.getColliderBox().contains(mouseX, mouseY)) {
	                System.exit(0);
	            }
	        }
	    }

	    @Override
	    public void mouseReleased(MouseEvent e) {
	    }

	    @Override
	    public void mouseEntered(MouseEvent e) {
	    }

	    @Override
	    public void mouseExited(MouseEvent e) {
	    }
}

