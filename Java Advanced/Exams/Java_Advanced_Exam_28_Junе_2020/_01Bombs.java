package com.company;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class _01Bombs {

    public static void main(String[] args) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffectQueue = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> bombCasingStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(bombCasingStack::push);

        Map<String, Integer> tableOfBombs = new TreeMap<>();
        tableOfBombs.put("Datura Bombs", 0);
        tableOfBombs.put("Cherry Bombs", 0);
        tableOfBombs.put("Smoke Decoy Bombs", 0);

        while (!bombEffectQueue.isEmpty() || !bombCasingStack.isEmpty()) {
            if (bombEffectQueue.isEmpty() || bombCasingStack.isEmpty() ||
                    isFilledPouch(tableOfBombs)) {
                break;
            }
            int bombEffect = bombEffectQueue.poll();
            int bombCasing = bombCasingStack.pop();
            int sum = bombEffect + bombCasing;

            switch (sum) {
                case 40:
                    tableOfBombs.put("Datura Bombs", tableOfBombs.get("Datura Bombs") + 1);
                    break;
                case 60:
                    tableOfBombs.put("Cherry Bombs", tableOfBombs.get("Cherry Bombs") + 1);
                    break;
                case 120:
                    tableOfBombs.put("Smoke Decoy Bombs", tableOfBombs.get("Smoke Decoy Bombs") + 1);
                    break;
                default:
                    bombEffectQueue.addFirst(bombEffect);
                    bombCasingStack.push(bombCasing - 5);
                    break;
            }
        }

        if (isFilledPouch(tableOfBombs)){
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        }else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffectQueue.isEmpty()){
            System.out.println("Bomb Effects: empty");
        }else {
            System.out.print("Bomb Effects: " + bombEffectQueue.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }

        if (bombCasingStack.isEmpty()){
            System.out.println("Bomb Casings: empty");
        }else {
            System.out.print("Bomb Casings: " + bombCasingStack.stream().map(String::valueOf).collect(Collectors.joining(", ")));
            System.out.println();
        }

        tableOfBombs.forEach((key,value) -> System.out.println(key + ": " + value));


    }

    private static boolean isFilledPouch(Map<String, Integer> tableOfBombs) {
        return tableOfBombs.get("Datura Bombs") >= 3 &&
                tableOfBombs.get("Cherry Bombs") >= 3 && tableOfBombs.get("Smoke Decoy Bombs") >= 3;
    }
}
