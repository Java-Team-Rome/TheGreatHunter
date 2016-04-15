package com.company.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

import com.company.events.MouseInput;
import com.company.graphics.Assets;
import com.company.graphics.Display;
import com.company.graphics.ImageLoader;
import com.company.models.prey.*;
import com.company.states.GameState;
import com.company.states.MainMenuState;
import com.company.states.State;
import com.company.states.StateManager;

public class GameEngine implements Runnable {

    private String title;
    private boolean isRunning;
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private MouseInput mouseInput;
    private State mainMenuState;
    private State gameState;
    
    public GameEngine(String title) {
        this.title = title;
    }

    public synchronized void start() {
        if (!isRunning) {
            this.isRunning = true;
            this.thread = new Thread(this);
            this.thread.start();
        }
    }

    public synchronized void stop() {
        if (isRunning) {
            try {
                this.isRunning = false;
                this.thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        this.init();

        int fps = 30;
        double timePerTick = 1_000_000_000.0 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while (isRunning) {
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1) {
                this.update();
                this.display();
                ticks++;
                delta--;
            }

            if (timer >= 1_000_000_000) {
                ticks = 0;
                timer = 0;
            }
        }

        this.stop();
    }

    private void update() {
    	  if(StateManager.getCurrentState() != null) {
              StateManager.getCurrentState().update();
          }
    }

    private void display() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();

        // -> START DRAWING
        graphics.clearRect(0, 0, 800, 600);
        
        if(StateManager.getCurrentState() != null) {
            StateManager.getCurrentState().display(graphics);
        }
        // -> END DRAWING

        this.graphics.dispose();
        this.bufferStrategy.show();
    }

    private void init() {
		Assets.init();
        this.display = new Display(this.title, 800, 600);
        this.mouseInput =new MouseInput(this.display);
        mainMenuState = new MainMenuState();
        //highScoreState = new HighScoresState();

        StateManager.setCurrentState(mainMenuState);
    }
}
