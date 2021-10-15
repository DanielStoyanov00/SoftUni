package com.company;

import java.util.Scanner;

public class RepeatStrings2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] words = scanner.nextLine().split(" ");

        for (String word : words) {
            String repeatedWord = repeatedWord(word, word.length());
            System.out.print(repeatedWord);
        }


    }

    private static String repeatedWord(String word, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(word);
        }
        return result.toString();


    }
}
