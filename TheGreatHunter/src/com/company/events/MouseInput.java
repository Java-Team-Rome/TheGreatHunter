package com.company.events;

import java.awt.Cursor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import com.company.graphics.Display;
import com.company.states.GameState;
import com.company.states.MainMenuState;
import com.company.states.StateManager;

public class MouseInput implements MouseListener, MouseMotionListener {
	private Display display;

	    public MouseInput(Display display) {
	        display.getCanvas().addMouseListener(this);
	        display.getCanvas().addMouseMotionListener(this);
	        
	        this.display = display;    
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
	                BufferedImage blankCursorImg = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
	                Cursor blankCursor = Toolkit.getDefaultToolkit().createCustomCursor(blankCursorImg, new Point(0, 0), null);
	    	        display.getCanvas().setCursor(blankCursor);
	            }

	            //High Scores Button
//	            if (MainMenuState.highScoreButton.getColliderBox().contains(mouseX, mouseY)) {
//	                StateManager.setCurrentState(new HighScoresState());
//	            }

	            //Exit Button
	            if (MainMenuState.exitButton.getColliderBox().contains(mouseX, mouseY)) {
	                System.exit(0);
	            }
	        } else if (StateManager.getCurrentState() instanceof GameState) {
	        	 GameState gameState = (GameState)StateManager.getCurrentState();
	        	 
	        	if (gameState.getCurrentPrey().getColliderBox().contains(mouseX, mouseY)) {
					gameState.killPrey(gameState.getCurrentPrey());
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

		@Override
		public void mouseDragged(MouseEvent e) {	
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			if (StateManager.getCurrentState() instanceof GameState) {
	        	 GameState gameState = (GameState)StateManager.getCurrentState();
	        	 gameState.setMousePosition(e.getX(), e.getY());
			}
		}
}

