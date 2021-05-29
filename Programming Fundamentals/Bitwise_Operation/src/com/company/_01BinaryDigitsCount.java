package com.company;

import java.util.Scanner;

public class _01BinaryDigitsCount {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int binaryDigit = Integer.parseInt(scanner.nextLine());

        int counter = 0;

        while (number != 0) {

            int bitReminder = number % 2;

            if (bitReminder == binaryDigit) {
                counter++;
            }

            number = number / 2;

        }
        System.out.println(counter);
    }
}
