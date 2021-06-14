package com.company;

import java.util.*;

public class _03PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> plants = new HashMap<>();
        Map<String, List<Double>> rating = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarity = Integer.parseInt(input[1]);
            plants.compute(plant, (k, v) -> rarity);
            rating.putIfAbsent(plant, new ArrayList<>());
        }

        String input;
        while (!"Exhibition".equals(input = scanner.nextLine())) {
            String[] tokens = input.split(": ");
            String command = tokens[0];
            String[] elements = tokens[1].split(" - ");
            String name = elements[0];

            if (!plants.containsKey(name)) {
                System.out.println("error");
                continue;
            }

            switch (command) {
                case "Rate":
                    double rate = Double.parseDouble(elements[1]);
                    rating.get(name).add(rate);
                    break;
                case "Update":
                    int rarity = Integer.parseInt(elements[1]);
                    plants.compute(name, (k, v) -> rarity);
                    break;
                case "Reset":
                    rating.get(name).clear();
                    break;
                default:
                    System.out.println("error");
            }
        }

        System.out.println("Plants for the exhibition:");
        plants.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue()
                        .thenComparingDouble(x -> rating.get(x.getKey()).stream()
                                .mapToDouble(Double::doubleValue)
                                .average().orElse(0.0))
                        .reversed())
                .forEach(e -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", e.getKey(), e.getValue(),
                        rating.get(e.getKey()).stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
    }


        }



