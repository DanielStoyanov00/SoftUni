package com.company;

import java.util.Scanner;

public class _09SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int totalSum = 0;
        int counter = 0;

        for (int i = 0; i < 100; i++) {

            if (i % 2 == 1) {
                counter++;
                totalSum += i;
                System.out.println(i);
            }
            if (counter == number) {
                break;
            }

        }
        System.out.printf("Sum: %d", totalSum);
    }
}
