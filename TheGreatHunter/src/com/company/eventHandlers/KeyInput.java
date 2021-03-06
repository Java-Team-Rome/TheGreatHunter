package com.company.eventHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.company.game.GameEngine;
import com.company.graphics.Display;
import com.company.states.InputNameState;
import com.company.states.StateManager;

public class KeyInput implements KeyListener{

    GameEngine gameEngine;

    public KeyInput(GameEngine gameengine, Display display) {
        this.gameEngine = gameengine;
        display.getCanvas().addKeyListener(this);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        // User input
        if (StateManager.getCurrentState() instanceof InputNameState) {
            if (key>='A' && key<='Z' && InputNameState.stringBuilger.length() < 8) {
                InputNameState.stringBuilger.append((char) key);
            }
            else if (key == KeyEvent.VK_BACK_SPACE && InputNameState.stringBuilger.length() > 0) {
                InputNameState.stringBuilger.deleteCharAt(InputNameState.stringBuilger.length() - 1);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

}