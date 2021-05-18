package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> userPoints = new HashMap<>();
        Map<String, Integer> languageCounter = new HashMap<>();

        String input = scanner.nextLine();

        while (!input.equals("exam finished")) {

            String[] splitArray = input.split("-");
            String userName = splitArray[0];
            if (splitArray.length == 3) {
                String language = splitArray[1];
                int points = Integer.parseInt(splitArray[2]);
                if (!userPoints.containsKey(userName)) {
                    userPoints.put(userName, points);
                } else {
                    if (userPoints.get(userName) < points) {
                        userPoints.put(userName, points);
                    }
                }
                if (!languageCounter.containsKey(language)) {
                    languageCounter.put(language, 1);
                } else {
                    languageCounter.put(language, languageCounter.get(language) + 1);
                }

            } else {
                userPoints.remove(userName);
            }


            input = scanner.nextLine();
        }


        System.out.println("Results:");
        userPoints.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " | " + e.getValue()));
        System.out.println("Submissions:");
        languageCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));


    }
}
