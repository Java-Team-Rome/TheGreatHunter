package com.company.models.prey;

import com.company.graphics.Assets;

public class Deer extends Mammal {
	
    public Deer(int x, int y) { 
    	super(x, y, Assets.deer, 80, 71, 45, 0.7);
    }

    @Override
    public void update(){

        this.getColliderBox().setBounds(this.getX(), this.getX(), this.getWidth(), this.getHeight());



        speed++;
        speed %= 3;
        this.setX(getX() - 15);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
