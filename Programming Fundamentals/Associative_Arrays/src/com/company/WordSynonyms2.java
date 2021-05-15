package com.company;

import java.util.*;

public class WordSynonyms2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int iterations = scanner.nextInt();

        Map<String, List<String>> words = new LinkedHashMap<>();

        for (int i = 0; i < iterations; i++) {
            String word = scanner.next();
            String synonym = scanner.next();


            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        for (Map.Entry<String, List<String>> entry : words.entrySet()) {
            System.out.println(entry.getKey() + " - " + String.join(", ", entry.getValue()));

        }


    }
}
