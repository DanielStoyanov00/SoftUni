package com.company;

import java.util.Scanner;

public class _07VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        double sum = 0;

        while (!command.equals("Start")) {

            double inputMoney = Double.parseDouble(command);
            if (inputMoney == 0.1 || inputMoney == 0.2 ||
                    inputMoney == 0.5 || inputMoney == 1 || inputMoney == 2) {

                sum += inputMoney;
            } else {
                System.out.printf("Cannot accept %.2f%n", inputMoney);
            }
            command = scanner.nextLine();
        }

        while (!command.equals("End")) {


            if (command.equals("Nuts")) {

                if (sum < 2.0) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Nuts");
                    sum -= 2.0;
                }
            } else if (command.equals("Water")) {

                if (sum < 0.7) {
                    System.out.println("Sorry, not enough money");
                } else {
                    System.out.println("Purchased Water");
                    sum -= 0.7;
                }
            } else if (command.equals("Crisps")) {

                if (sum < 1.5) {
                    System.out.println("Sorry, not enough money");
                } else {
                    sum -= 1.5;
                    System.out.println("Purchased Crisps");
                }
            } else if (command.equals("Soda")) {

                if (sum < 0.8) {
                    System.out.println("Sorry, not enough money");
                } else {
                    sum -= 0.8;
                    System.out.println("Purchased Soda");
                }
            } else if (command.equals("Coke")) {

                if (sum < 1.0) {
                    System.out.println("Sorry, not enough money");
                } else {

                    System.out.println("Purchased Coke");
                    sum -= 1;
                }
            } else if (!command.equals("Start")) {
                System.out.println("Invalid product");
            }
            command = scanner.nextLine();

        }
        System.out.printf("Change: %.2f", sum);
    }
}

