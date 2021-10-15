package com.company;

import java.util.Scanner;

public class _05AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstDigit = Integer.parseInt(scanner.nextLine());
        int secondDigit = Integer.parseInt(scanner.nextLine());
        int thirdDigit = Integer.parseInt(scanner.nextLine());

        System.out.println(subtract(firstDigit, secondDigit, thirdDigit));

    }

    static int sumOfFirstAndSecondDigits(int firstDigit, int secondDigit) {
        int sum = 0;
        sum = firstDigit + secondDigit;

        return sum;
    }

    static int subtract(int firstDigit, int secondDigit, int thirdDigit) {
        int sumOfFirstAndSecond = sumOfFirstAndSecondDigits(firstDigit, secondDigit);


        return sumOfFirstAndSecond - thirdDigit;

    }
}
