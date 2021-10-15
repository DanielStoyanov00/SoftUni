package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class LegendaryFarming3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, Integer> keyMaterials = new TreeMap<>();
        TreeMap<String, Integer> junkMaterials = new TreeMap<>();

        keyMaterials.put("shards", 0);
        keyMaterials.put("fragments", 0);
        keyMaterials.put("motes", 0);

        int lastNumber = 0;
        String winner = " ";

        while (winner.equals(" ")) {
            String[] data = scanner.nextLine().toLowerCase().split("\\s+");

            for (int i = 0; i < data.length; i++) {
                if (i % 2 != 0) {
                    if (data[i].equals("shards") || data[i].equals("fragments") || data[i].equals("motes")) {
                        lastNumber = keyMaterials.get(data[i]);
                        keyMaterials.put(data[i], lastNumber + Integer.parseInt(data[i - 1]));

                        if (winner.equals(" ")) {
                            winner = determinesWinner(keyMaterials, winner, data[i]);
                            if (!winner.equals(" ")) {
                                recalculatesWinnerMaterial(keyMaterials, data[i]);
                                break;
                            }
                        }
                    } else {
                        junkMaterials.putIfAbsent(data[i], 0);
                        lastNumber = junkMaterials.get(data[i]);
                        junkMaterials.put(data[i], lastNumber + Integer.parseInt(data[i - 1]));
                    }
                }
            }

        }

        System.out.println(winner + " obtained!");


        keyMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry.comparingByKey()))
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));


        junkMaterials
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByKey())
                .forEach(result -> System.out.printf("%s: %d%n", result.getKey(), result.getValue()));

    }

    public static String determinesWinner(TreeMap<String, Integer> keyMats, String winner, String key) {
        if (keyMats.get(key) >= 250) {
            switch (key) {
                case "shards":
                    winner = "Shadowmourne";
                    break;
                case "fragments":
                    winner = "Valanyr";
                    break;
                case "motes":
                    winner = "Dragonwrath";
                    break;
                default:
                    break;
            }
        }
        return winner;
    }

    public static void recalculatesWinnerMaterial(TreeMap<String, Integer> keyMaterials, String key) {
        int newValue = keyMaterials.get(key) - 250;
        keyMaterials.put(key, newValue);
    }

}

