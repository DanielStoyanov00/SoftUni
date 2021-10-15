package com.company;

import java.util.Scanner;

public class TextFilter4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] forbiddenWords = scanner.nextLine().split(", ");
        String input = scanner.nextLine();

        for (String forbiddenWord : forbiddenWords) {
            if (input.contains(forbiddenWord)) {
                String wordOfStars = convertWordToStars(forbiddenWord);
                input = input.replace(forbiddenWord, wordOfStars);
            }
        }
        System.out.println(input);


    }

    private static String convertWordToStars(String forbiddenWord) {

        StringBuilder worOfStars = new StringBuilder();

        for (int i = 0; i < forbiddenWord.length(); i++) {
            worOfStars.append("*");
        }
        return worOfStars.toString();

    }
}
