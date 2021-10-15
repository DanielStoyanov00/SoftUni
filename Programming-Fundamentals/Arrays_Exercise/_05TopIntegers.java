package com.company;


import java.util.Scanner;

public class _05TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] line = scanner.nextLine().split(" ");
        int[] numbers = new int[line.length];


        for (int i = 0; i < line.length; i++) {
            numbers[i] = Integer.parseInt(line[i]);
        }

        for (int i = 0; i <= numbers.length - 1; i++) {
            int currentDigit = numbers[i];
            boolean itsBigger = false;
            for (int j = i + 1; j < numbers.length; j++) {

                if (currentDigit > numbers[j]) {
                    itsBigger = true;
                } else {
                    itsBigger = false;
                    break;
                }
            }
            if (itsBigger) {
                System.out.print(currentDigit + " ");
            }
            if (i == numbers.length - 1) {
                System.out.print(currentDigit);
            }
        }


    }
}
