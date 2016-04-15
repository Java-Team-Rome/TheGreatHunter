package com.company.game;

import com.company.models.prey.*;
import com.company.utils.RandomGenerator;

public class MapInitializer {
    public static Prey[] PopulateMap() {
        int amountOfPray = 10;
        Prey[] pray = generatePray(amountOfPray);
        return pray;
    }
    private static Prey[] generatePray(int amountOfPray) {
        String [] pray ={"fox","deer","duck","rabbit","wolf","boar","eagle"};
        Prey [] prayArray =new Prey[amountOfPray];
        for (int i = 0; i <amountOfPray ; i++) {
            String randomPray = pray[RandomGenerator.getNextRandom(pray.length)];
            int x = RandomGenerator.getNextRandom(800);
            int y = RandomGenerator.getNextRandom(600);
            Prey prayToBeCreated;

            switch (randomPray) {
                case "fox":
                    prayToBeCreated = new Fox(x,y);
                    prayArray[i]=prayToBeCreated;
                    break;
                case "deer":
                    prayToBeCreated = new Deer(x,y);
                    prayArray[i]=prayToBeCreated;
                    break;
                case "rabbit":
                    prayToBeCreated = new Rabbit(x,y);
                    prayArray[i]=prayToBeCreated;
                    break;
                case "wolf":
                    prayToBeCreated = new Wolf(x,y);
                    prayArray[i]= prayToBeCreated;
                    break;
                case "boar":prayToBeCreated = new Boar(x,y);
                    prayArray[i]= prayToBeCreated;
                    break;
                case "eagle":prayToBeCreated = new Eagle(x,y);
                    prayArray[i]= prayToBeCreated;
                    break;
                case "duck":prayToBeCreated = new Duck(x,y);
                    prayArray[i]=prayToBeCreated;
                    break;
            }

        }
        return prayArray;
    }
}
