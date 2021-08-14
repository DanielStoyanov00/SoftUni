package com.company;

import java.util.Scanner;

public class _02VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine().toLowerCase();

        System.out.println(getVowelLetters(word));

    }

    static int getVowelLetters(String word) {

        String[] text = word.toLowerCase().split("");
        int counter = 0;

        for (int i = 0; i < text.length; i++) {

            if (text[i].equals("a") || text[i].equals("e") || text[i].equals("o") || text[i].equals("i") ||
                    text[i].equals("u") || text[i].equals("y")) {
                counter++;
            }

        }

        return counter;
    }

}
