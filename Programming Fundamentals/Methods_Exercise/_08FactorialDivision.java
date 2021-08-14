package com.company;

import java.util.Scanner;

public class _08FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());

        System.out.printf("%.2f", 1.0 * factorial(first) / factorial(second));
    }

    static long factorial(int digit) {
        long fact = 1;
        for (int i = 1; i <= digit; i++) {
            fact = fact * i;
        }
        return fact;
    }
}
