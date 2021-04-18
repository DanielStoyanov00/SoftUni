package com.company;

import java.util.*;

public class ListOfProducts6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        List<String> words = new ArrayList<>();


        for (int i = 0; i < number; i++) {
            String word = scanner.nextLine();
            words.add(word);
        }
        Collections.sort(words);

        for (int i = 0; i < words.size(); i++) {
            System.out.printf("%d.%s%n", i + 1, words.get(i));
        }
    }
}
