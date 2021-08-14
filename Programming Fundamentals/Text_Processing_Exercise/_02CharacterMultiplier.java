package com.company;

import java.util.Scanner;

public class _02CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] array = line.split(" ");

        int sum = 0;

        if (array[0].length() >= array[1].length()) {
            for (int i = 0; i < array[0].length(); i++) {
                int counter = array[1].length();

                if (counter <= i) {
                    sum += array[0].charAt(i);
                } else {
                    sum += array[0].charAt(i) * array[1].charAt(i);
                }
            }
        } else {
            for (int i = 0; i < array[1].length(); i++) {
                int counter = array[0].length();

                if (counter <= i) {
                    sum += array[1].charAt(i);
                } else {
                    sum += array[0].charAt(i) * array[1].charAt(i);
                }
            }
        }
        System.out.println(sum);
    }
}
