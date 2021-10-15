package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02AdAstra {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();

        String regex = "([#||])(?<foodName>[a-zA-Z]+\\s*[a-zA-Z]+)\\1(?<exDate>\\d{2}/\\d{2}/\\d{2})\\1(?<calories>\\d+)\\1";


        List<String> items = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        int totalCalories = 0;
        int days = 0;

        while (matcher.find()) {
            totalCalories += Integer.parseInt(matcher.group("calories"));

            items.add(String.format("Item: %s, Best before: %s, Nutrition: %d",
                    matcher.group("foodName"),matcher.group("exDate"), Integer.parseInt(matcher.group("calories")) ));

        }
        while (totalCalories >= 2000) {
            days++;
            totalCalories -= 2000;
        }
        System.out.printf("You have food to last you for: %d days!\n", days);

        for (String item : items) {
            System.out.println(item);
        }


    }


    }

