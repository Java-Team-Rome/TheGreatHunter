package com.company.game;

import com.company.models.prey.*;
import com.company.utils.RandomGenerator;

public class MapInitializer {
    
     public static Prey generatePray() {
        String[] prey = {"fox", "deer", "duck", "rabbit", "wolf", "boar", "eagle"};
        
        	int randomIndex = RandomGenerator.getNextRandom(prey.length);
            String randomPrey = prey[randomIndex];
            int randomX = 0;
            int randomY = 0;
            
            if (randomPrey.equals("duck") || randomPrey.equals("eagle")) {
            	randomX = RandomGenerator.getNextRandom(700);
            	randomY = RandomGenerator.getNextRandom(200);
			} else {
				randomX = RandomGenerator.getNextRandom(700);
				randomY = RandomGenerator.getNextRandom(300) + 200;
            }

            Prey prayToBeCreated = null;

            switch (randomPrey) {
                case "fox":
                    prayToBeCreated = new Fox(randomX, randomY);
                    break;
                case "deer":
                    prayToBeCreated = new Deer(randomX, randomY);
                    break;
                case "rabbit":
                    prayToBeCreated = new Rabbit(randomX, randomY);
                    break;
                case "wolf":
                    prayToBeCreated = new Wolf(randomX, randomY);
                    break;
                case "boar":
                	prayToBeCreated = new Boar(randomX, randomY);
                    break;
                case "eagle":
                	prayToBeCreated = new Eagle(randomX, randomY);
                    break;
                case "duck":
                	prayToBeCreated = new Duck(randomX, randomY);
                    break;                  	
            }
            
        return prayToBeCreated;
    }
}
