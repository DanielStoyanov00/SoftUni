package com.company;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> lettersAndCount = new TreeMap<>();

        String[] text = scanner.nextLine().split("");

        if (text[0].isEmpty()){
            return;
        }

        for (String symbol : text) {
                if (!lettersAndCount.containsKey(symbol)){
                    lettersAndCount.put(symbol, 1);
                }else {
                    lettersAndCount.put(symbol, lettersAndCount.get(symbol) + 1);
                }
            }

        lettersAndCount.entrySet()
        .stream()
        .forEach(symbol -> System.out.printf("%s: %d time/s\n", symbol.getKey(), symbol.getValue()));




    }
}
