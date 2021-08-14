package com.company;

import java.util.Scanner;

public class _03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[] firstArray = new int[number];
        int[] secondArray = new int[number];

        for (int i = 0; i < number; i++) {
            String[] line = scanner.nextLine().split(" ");
            if (i % 2 == 0) {
                firstArray[i] = Integer.parseInt(line[1]);
                secondArray[i] = Integer.parseInt(line[0]);
            } else {
                firstArray[i] = Integer.parseInt(line[0]);
                secondArray[i] = Integer.parseInt(line[1]);
            }


        }
        for (int currentNumber : secondArray) {
            System.out.print(currentNumber + " ");
        }
        System.out.println();
        for (int currentNumber : firstArray) {
            System.out.print(currentNumber + " ");
        }
    }
}
