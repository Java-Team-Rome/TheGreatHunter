package com.company.game;

import java.awt.*;
import java.awt.image.BufferStrategy;

import com.company.graphics.Assets;
import com.company.graphics.Display;
import com.company.graphics.ImageLoader;
import com.company.models.prey.*;
import com.company.states.MainMenuState;

public class GameEngine implements Runnable {

    private String title;
    private boolean isRunning;
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    
    Prey prey;
    
    int timer;

    MainMenuState mainMenu;
    
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
                this.draw();
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
    	timer++;
    	
    	if (timer == 3) {
    		prey.isHasEscaped();
    		prey = MapInitializer.generatePray();
    		timer = 0;
		}
    	prey.update();
        
    }

    private void draw() {
        this.bufferStrategy = this.display.getCanvas().getBufferStrategy();

        if (this.bufferStrategy == null) {
            this.display.getCanvas().createBufferStrategy(2);
            return;
        }

        this.graphics = this.bufferStrategy.getDrawGraphics();

        // -> START DRAWING
        graphics.clearRect(0, 0, 800, 600);
        this.graphics.drawImage(ImageLoader.loadImage("/green.jpg"), 0, 0, 800, 600, null);
        
    	if (prey.isAlive() && !prey.isHasEscaped()) {
    		prey.display(graphics);
		}
        
        // -> END DRAWING

        this.graphics.dispose();
        this.bufferStrategy.show();

    }

    private void init() {

        this.display = new Display(this.title, 800, 600);
        Assets.init();
        
        
        mainMenu = new MainMenuState();
        
        prey = MapInitializer.generatePray();
    }
}
