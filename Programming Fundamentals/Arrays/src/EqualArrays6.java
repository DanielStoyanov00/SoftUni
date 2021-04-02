package com.company;

import java.util.Scanner;

public class EqualArrays6 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();

        String[] firstNumberAsString = first.split(" ");

        int[] firstNumbers = new int[firstNumberAsString.length];

        for (int i = 0; i < firstNumbers.length; i++) {
            firstNumbers[i] = Integer.parseInt(firstNumberAsString[i]);

        }

        String second = scanner.nextLine();

        String[] secondNumberAsString = second.split(" ");

        int[] secondNumbers = new int[secondNumberAsString.length];

        for (int j = 0; j < secondNumbers.length; j++) {
            secondNumbers[j] = Integer.parseInt(secondNumberAsString[j]);
        }

        boolean areEqual = true;
        int indexNotEqual = -1;
        for (int i = 0; i < firstNumbers.length; i++) {
            if (firstNumbers[i] != secondNumbers[i]) {
                areEqual = false;
                indexNotEqual = i;
                break;
            }

        }

        int sum = 0;
        if (areEqual) {
            for (int number : firstNumbers) {
                sum += number;
            }
            System.out.printf("Arrays are identical. Sum: %d", sum);
        } else {
            System.out.printf("Arrays are not identical. Found difference at %d index.", indexNotEqual);
        }

    }
}
