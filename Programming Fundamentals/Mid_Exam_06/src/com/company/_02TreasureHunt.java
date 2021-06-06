package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> initialLoot = Arrays.stream(scanner.nextLine().split("\\|"))
                .collect(Collectors.toList());


        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Loot":
                    for (int i = 1; i < tokens.length; i++) {
                        if (!initialLoot.contains(tokens[i])) {
                            initialLoot.add(0, tokens[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(tokens[1]);
                    if (index >= 0 && index < initialLoot.size()) {
                        String value = initialLoot.get(index);
                        initialLoot.remove(index);
                        initialLoot.add(value);
                    }
                    break;
                case "Steal":
                    int numberOfStolenItems = Integer.parseInt(tokens[1]);

                    if (numberOfStolenItems >= initialLoot.size()) {
                        int counter = 0;
                        for (String item : initialLoot) {
                            counter++;
                            if (counter == initialLoot.size()) {
                                System.out.println(item);
                            } else {
                                System.out.printf("%s, ", item);
                            }
                        }
                        System.out.println("Failed treasure hunt.");
                        return;
                    } else {
                        int counter = initialLoot.size() - numberOfStolenItems;
                        for (int i = initialLoot.size() - numberOfStolenItems; i <= initialLoot.size() - 1; i++) {
                            counter++;
                            if (counter == initialLoot.size()) {
                                System.out.println(initialLoot.get(i));
                            } else {
                                System.out.printf("%s, ", initialLoot.get(i));
                            }
                        }

                    }
                    int counter = initialLoot.size() - 1 - numberOfStolenItems;
                    for (int i = initialLoot.size() - 1; i >= initialLoot.size()  - numberOfStolenItems; i--) {
                        if (counter != i) {
                            initialLoot.remove(i);
                        } else {
                            break;
                        }

                    }
                    break;
                default:
                    break;
            }

            command = scanner.nextLine();
        }

        double numberOfLetters = 0;
        for (String currentWord : initialLoot) {
            numberOfLetters += currentWord.length();

        }
        double averageSum = numberOfLetters / (initialLoot.size());
        System.out.printf("Average treasure gain: %.2f pirate credits.", averageSum);


    }
}

