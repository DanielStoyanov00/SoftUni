package com.company;

import java.util.Scanner;

public class _06MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.nextLine();

        System.out.println(output(word));


    }


    static String output(String word) {

        int position;
        int length;

        if (word.length() % 2 == 0) {
            position = word.length() / 2 - 1;
            length = 2;
        } else {
            position = word.length() / 2;
            length = 1;
        }

        return word.substring(position, position + length);
    }

}
