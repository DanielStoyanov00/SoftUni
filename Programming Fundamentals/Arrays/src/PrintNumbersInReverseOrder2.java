package com.company;

import java.util.Scanner;

public class PrintNumbersInReverseOrder2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] array = new int[n];

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            array[i] = number;

        }

        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");

        }

    }
}
