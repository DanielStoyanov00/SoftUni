package com.company;

import java.util.Scanner;

public class CondenseArrayToNumber7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numbersAsString = scanner.nextLine();

        String[] numbersSplitBySpace = numbersAsString.split(" ");

        int[] numbers = new int[numbersSplitBySpace.length];


        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(numbersSplitBySpace[i]);

        }

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j] + numbers[j + 1];
            }
        }
        System.out.println(numbers[0]);


    }
}
