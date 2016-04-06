package com.company.utils;

import java.util.Random;

public class RandomGenerator {
    private static Random random;

    private static void init(){
        random = new Random();
    }
    public static int getNextRandom()
    {
        if (random == null){
            init();
        }
        return random.nextInt(100);
    }

}
