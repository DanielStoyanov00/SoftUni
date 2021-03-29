package com.company;

import java.util.Scanner;

public class SignOfIntegerNumbers1 {

    static void printNumber(int number) {
        if (number == 0) {
            System.out.println("The number 0 is zero.");
        } else if (number < 0) {
            System.out.printf("The number %d is negative.", number);
        } else {
            System.out.printf("The number %d is positive.", number);
        }

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printNumber(scanner.nextInt());
    }


}
