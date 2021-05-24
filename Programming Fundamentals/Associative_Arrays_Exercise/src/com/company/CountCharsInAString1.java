package com.company;

import java.util.*;

public class CountCharsInAString1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Character, Integer> numberOfSymbols = new LinkedHashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) != ' '){
                char symbol = input.charAt(i);
                if (numberOfSymbols.containsKey(symbol)){
                    numberOfSymbols.put(symbol, numberOfSymbols.get(symbol) + 1);
                } else {
                    numberOfSymbols.put(symbol, 1);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : numberOfSymbols.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }

        }




    }

