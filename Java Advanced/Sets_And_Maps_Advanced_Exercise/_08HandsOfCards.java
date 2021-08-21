package com.company;

import java.util.*;

public class _08HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> nameAndPoints = new LinkedHashMap<>();
        Map<String, List<String>> nameAndCards = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] lineOfNameAndCards = input.split(": ");
            String name = lineOfNameAndCards[0];
            nameAndPoints.putIfAbsent(name, 0);

            String[] lineOfCards = lineOfNameAndCards[1].split(", ");
            nameAndCards.putIfAbsent(name, new ArrayList<>());

            for (String card : lineOfCards) {
                if (nameAndCards.containsKey(name) && !nameAndCards.get(name).contains(card)) {
                    nameAndCards.get(name).add(card);
                }
            }

            input = scanner.nextLine();
        }
        fillingMap(nameAndPoints, nameAndCards);

        printingTheResult(nameAndPoints);
    }


    private static void fillingMap(Map<String, Integer> nameAndPoints, Map<String, List<String>> nameAndCards) {
        // power of J,Q,K,A -> 11,12,13,14
        // type of S,H,D,C -> 4,3,2,1

        for (Map.Entry<String, List<String>> card : nameAndCards.entrySet()) {
            int sum = 0;
            for (int i = 0; i < card.getValue().size(); i++) {
                String currentCard = card.getValue().get(i);
                // card which length is 3, always have power 10
                if (currentCard.length() == 3) {
                    String lastIndex = currentCard.split("")[2];
                    switch (lastIndex) {
                        case "S":
                            sum += 10 * 4;
                            break;
                        case "H":
                            sum += 10 * 3;
                            break;
                        case "D":
                            sum += 10 * 2;
                            break;
                        case "C":
                            sum += 10;
                            break;
                    }
                } else if (currentCard.length() == 2) {
                    String[] powerAndType = currentCard.split("");
                    String power = powerAndType[0];
                    String type = powerAndType[1];

                    switch (power) {
                        case "J":
                            switch (type) {
                                case "S":
                                    sum += 11 * 4;
                                    break;
                                case "H":
                                    sum += 11 * 3;
                                    break;
                                case "D":
                                    sum += 11 * 2;
                                    break;
                                case "C":
                                    sum += 11;
                                    break;
                            }
                            break;
                        case "Q":
                            switch (type) {
                                case "S":
                                    sum += 12 * 4;
                                    break;
                                case "H":
                                    sum += 12 * 3;
                                    break;
                                case "D":
                                    sum += 12 * 2;
                                    break;
                                case "C":
                                    sum += 12;
                                    break;
                            }
                            break;
                        case "K":
                            switch (type) {
                                case "S":
                                    sum += 13 * 4;
                                    break;
                                case "H":
                                    sum += 13 * 3;
                                    break;
                                case "D":
                                    sum += 13 * 2;
                                    break;
                                case "C":
                                    sum += 13;
                                    break;
                            }
                            break;
                        case "A":
                            switch (type) {
                                case "S":
                                    sum += 14 * 4;
                                    break;
                                case "H":
                                    sum += 14 * 3;
                                    break;
                                case "D":
                                    sum += 14 * 2;
                                    break;
                                case "C":
                                    sum += 14;
                                    break;
                            }
                            break;
                        default:
                            int number = Integer.parseInt(power);
                            switch (type) {
                                case "S":
                                    sum += number * 4;
                                    break;
                                case "H":
                                    sum += number * 3;
                                    break;
                                case "D":
                                    sum += number * 2;
                                    break;
                                case "C":
                                    sum += number;
                                    break;
                            }
                    }
                }
            }
            // adding sum into the nameAndPoints map of each key
            nameAndPoints.put(card.getKey(), nameAndPoints.get(card.getKey()) + sum);

        }
    }

    private static void printingTheResult(Map<String, Integer> nameAndPoints) {
        nameAndPoints.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.printf("%s: %d\n", entry.getKey(), entry.getValue());
                });
    }
}
