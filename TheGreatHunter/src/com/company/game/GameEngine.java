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
    private Rabbit rabbit;
    private Fox fox;
    private Duck duck;
    private Wolf wolf;
    private Deer deer;
    private Boar boar;
    private Eagle eagle;

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
        rabbit.update();
        fox.update();
        duck.update();
        wolf.update();
        deer.update();
        boar.update();
        eagle.update();
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
        
        for (Prey a :MapInitializer.PopulateMap()) {
            a.display(graphics);
        }
        
        rabbit.display(graphics);
        fox.display(graphics);
        duck.display(graphics);
        wolf.display(graphics);
        deer.display(graphics);
        boar.display(graphics);
        eagle.display(graphics);

        // -> END DRAWING

        this.graphics.dispose();
        this.bufferStrategy.show();

    }

    private void init() {

        this.display = new Display(this.title, 800, 600);
        Assets.init();
        rabbit = new Rabbit(100, 400);
        fox = new Fox(200, 200);
        duck = new Duck(100, 100);
        wolf = new Wolf(300, 300);
        deer = new Deer(200, 300);
        boar = new Boar(300,200);
        eagle = new Eagle(150,200);
        
        mainMenu = new MainMenuState();

    }
}
