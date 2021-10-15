package com.company;

import java.util.*;

public class _02WordSynonyms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<String>> words = new LinkedHashMap<>();

        int numberOfWords = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfWords; i++) {
            String word = scanner.nextLine();
            String synonym = scanner.nextLine();

            words.putIfAbsent(word, new ArrayList<>());
            words.get(word).add(synonym);
        }

        words.forEach((key, value) -> {
            System.out.println(key + " - " + String.join(", ", value));
        });



    }
}
