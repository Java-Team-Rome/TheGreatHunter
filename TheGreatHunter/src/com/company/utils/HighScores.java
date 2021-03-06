package com.company.utils;

import com.company.models.HunterScore;

import java.io.*;
import java.util.*;

public class HighScores {

    private static TreeMap<String,HunterScore> highScores = new TreeMap<>();
    
    public static void load() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Constants.HIGH_SCORES_PATH))) {
            String line = fileReader.readLine();
            String[] input;

            while (line != null) {
                input = line.split(" ");
                String name = input[0];
                Double gold = Double.parseDouble(input[1]);
                int amountOfPreyKilled = Integer.parseInt(input[2]);

                if (highScores.containsKey(name)) {
                    if (highScores.get(name).getAmountOfPreyKilled() < amountOfPreyKilled) {
                        highScores.put(name, new HunterScore(gold, amountOfPreyKilled));
                    }
                } else {
                    highScores.put(name, new HunterScore(gold, amountOfPreyKilled));
                }

                line = fileReader.readLine();
            }
        } catch (IOException ioex) {
            System.err.println("Cannot read the file");
        }
    }
    
    public static void save(String name, HunterScore score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Constants.HIGH_SCORES_PATH, true), true)) {
            writer.printf("%s %.2f %d", name, score.getGold(), score.getAmountOfPreyKilled());
            writer.println();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static TreeMap<String, HunterScore> getScores() {
        return highScores;
    }
}
