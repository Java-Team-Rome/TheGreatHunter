package com.company.models.prey;

import com.company.graphics.Assets;

public class Fox extends Mammal {

    public Fox(int x, int y) {
        super(x, y, Assets.fox, 153, 108, 14, 0.77);
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

