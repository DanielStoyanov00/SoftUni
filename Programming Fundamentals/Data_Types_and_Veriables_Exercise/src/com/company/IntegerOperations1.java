package com.company;

import java.util.Scanner;

public class IntegerOperations1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        int fourthNumber = Integer.parseInt(scanner.nextLine());

        int result = ((firstNumber + secondNumber) / thirdNumber) * fourthNumber;
        System.out.printf("%d", result);
    }
}
