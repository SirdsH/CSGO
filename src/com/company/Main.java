package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {

            BufferedReader br = new BufferedReader(new FileReader("CSGO-Weapons-Data.txt"));
            String line;
            line = br.readLine();
            List<CSGO> listOfCsgo = new ArrayList<CSGO>();

            while ((line = br.readLine()) != null) {
                String[] splitLine = line.split(",");
                listOfCsgo.add(new CSGO(splitLine[0], splitLine[1], Integer.parseInt(splitLine[2].replace("$", "")), Integer.parseInt(splitLine[6]), Integer.parseInt(splitLine[7])));
            }

            OptionalDouble avg = listOfCsgo.stream()
                    .mapToDouble(i -> i.getPrice())
                    .average();

            String rofVal = listOfCsgo.stream()
                    .filter(side -> side.getTeam().equals("T"))
                    .filter(rof -> rof.getRof() < 200)
                    .map(name -> name.getName())
                    .collect(Collectors.joining(","));

            String highestDmg = listOfCsgo.stream()
                    .sorted((a, b) -> b.getDamage() - a.getDamage())
                    .limit(4)
                    .map(name -> name.getName() + " (" + name.getDamage() + ")")
                    .collect(Collectors.joining(","));

            System.out.println("Average price: " + avg.getAsDouble());
            System.out.println("Under 200 rof t guns: " + rofVal);
            System.out.println("Max damage: " + highestDmg);



        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
