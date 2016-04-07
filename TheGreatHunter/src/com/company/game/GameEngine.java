package com.company.game;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.company.graphics.Display;
import com.company.graphics.ImageLoader;
import com.company.graphics.SpriteSheet;

public class GameEngine implements Runnable {

    private String title;
    private boolean isRunning = false;
    private Display display;
    private Thread thread;
    private BufferStrategy bufferStrategy;
    private Graphics graphics;
    private int x;
    private SpriteSheet sheet;

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

        // -> START DRAWING

        graphics.clearRect(0, 0, 800, 600);
        this.graphics.drawImage(ImageLoader.loadImage("/green.jpg"), 0, 0, 800, 600, null);
        this.graphics.drawImage(this.sheet.crop(0, 0, 85, 83), 50, 450, null);
        

        // -> END DRAWING

        this.bufferStrategy.show();
        this.graphics.dispose();      
    }

    private void init() {

        this.display = new Display(this.title, 800, 600);
        this.sheet = new SpriteSheet(ImageLoader.loadImage("/rabbit.png"));
        this.x = 50;
    }
}
