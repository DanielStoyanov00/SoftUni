package com.company;

import java.util.Scanner;

public class EvenAndOddSubtraction5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] numbersAsString = input.split(" ");

        int[] numbers = new int[numbersAsString.length];

        int evenSum = 0;
        int oddSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersAsString[i]);

            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }

        }
        System.out.println(evenSum - oddSum);
    }
}
