package com.company;

import java.util.Scanner;

public class _05OddTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");

        int[] numbers = new int[line.length];
        int result = numbers[0];


        for (int i = 0; i < line.length; i++) {
            int number = Integer.parseInt(line[i]);
            numbers[i] = number;
        }


        for (int i = 0; i < numbers.length; i++) {

            result = result ^ numbers[i];

        }

        System.out.println(result);
    }
}
