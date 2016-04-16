package com.company.utils;

import com.company.models.HunterScore;

import java.io.*;
import java.util.*;

public class HighScores {
	
    private static String ScoresPath = "resources/HighScores.txt";
    
    private static TreeMap<String,HunterScore> highScores = new TreeMap<>();
    
    public static TreeMap<String,HunterScore> getScores()
    {
        return highScores;
    }
    
    public static void load() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(ScoresPath))) {
            String line = fileReader.readLine();
            String[] input;

            while (line != null) {
                input = line.split(" ");
                String name = input[0];
                Double gold = Double.parseDouble(input[1]);
                int amountOfPreyKilled = Integer.parseInt(input[2]);
                highScores.put(name, new HunterScore(gold, amountOfPreyKilled));
                line = fileReader.readLine();
            }
        } catch (IOException ioex) {
            System.err.println("Cannot read the file");
        }
    }
    
    public static void save(String name, HunterScore score) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ScoresPath,true),true)) {
            writer.println(name + " " + score.getGold() + " " + score.getAmountOfPreyKilled());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
