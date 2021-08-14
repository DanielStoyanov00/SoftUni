package com.company;

import java.util.Scanner;

public class _03GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double initialBalance = Double.parseDouble(scanner.nextLine());
        double gamePrice = 0.0;
        double totalExpenses = 0;


        String input = scanner.nextLine();

        while (!input.equals("Game Time")) {

            switch (input) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    gamePrice = 39.99;
                    if (initialBalance >= gamePrice) {
                        initialBalance -= gamePrice;
                        totalExpenses += gamePrice;
                        System.out.printf("Bought %s\n", input);
                        if (initialBalance == 0) {
                            System.out.println("Out of money!");
                            return;
                        }
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    gamePrice = 15.99;
                    if (initialBalance >= gamePrice) {
                        initialBalance -= gamePrice;
                        totalExpenses += gamePrice;
                        System.out.printf("Bought %s\n", input);
                        if (initialBalance == 0) {
                            System.out.println("Out of money!");
                            return;
                        }
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    gamePrice = 19.99;
                    if (initialBalance >= gamePrice) {
                        initialBalance -= gamePrice;
                        totalExpenses += gamePrice;
                        System.out.printf("Bought %s\n", input);
                        if (initialBalance == 0) {
                            System.out.println("Out of money!");
                            return;
                        }
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    gamePrice = 59.99;
                    if (initialBalance >= gamePrice) {
                        initialBalance -= gamePrice;
                        totalExpenses += gamePrice;
                        System.out.printf("Bought %s\n", input);
                        if (initialBalance == 0) {
                            System.out.println("Out of money!");
                            return;
                        }
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    gamePrice = 29.99;
                    if (initialBalance >= gamePrice) {
                        initialBalance -= gamePrice;
                        totalExpenses += gamePrice;
                        System.out.printf("Bought %s\n", input);
                        if (initialBalance == 0) {
                            System.out.println("Out of money!");
                            return;
                        }
                    } else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }

            input = scanner.nextLine();
        }

        if (initialBalance > 0) {
            System.out.printf("Total spent: $%.2f. Remaining: $%.2f", totalExpenses, initialBalance);
        }


    }
}
