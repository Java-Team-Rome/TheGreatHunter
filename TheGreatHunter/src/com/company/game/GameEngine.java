package com.company.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.company.graphics.Display;

public class GameEngine implements Runnable {

	private String title;
    private boolean isRunning = false;
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private int x;
    
    BufferedImage background;
    
    public GameEngine(String title) {
    	this.title = title;
    }
    
	public synchronized void start() {
        if (isRunning) {
            return;
        }
        
        this.isRunning = true;
        this.thread = new Thread(this);
        thread.start();
    }

	public synchronized void stop() {
        if (!isRunning) {
            return;
        }

        this.isRunning = false;

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
	
	@Override
	public void run() {
		this.init();

        while (isRunning) {
           this.update();
           this.draw();
        }

        this.stop();
	}
	
	private void update() {
		x++;
	}
	
	private void draw() {
		this.bufferStrategy = this.display.getCanvas().getBufferStrategy();
		
		if (this.bufferStrategy == null) {
			this.display.getCanvas().createBufferStrategy(2);
			return;
		}
		
		this.graphics = this.bufferStrategy.getDrawGraphics();
		
		// -> START DROWING
		graphics.fillRect(100, 100, 100, 100);
		
		
		// -> END DROWING
		
		this.graphics.dispose();
		this.bufferStrategy.show();
	}
	
	private void init() {

        this.display = new Display(this.title, 800, 600);
        
        this.x = 50;
    }
}
