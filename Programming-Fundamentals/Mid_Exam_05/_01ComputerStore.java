package com.company;

import java.util.Scanner;

public class _01ComputerStore {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double priceWithoutTaxes = 0;
        double taxes = 0;

        String price = scanner.nextLine();
        while (!price.equals("special")) {
            if (price.equals("regular")) {
                break;
            }

            double currentPrice = Double.parseDouble(price);
            if (currentPrice < 0) {
                System.out.println("Invalid price!");
                priceWithoutTaxes += Math.abs(currentPrice);
                taxes += Math.abs(currentPrice * 0.20);
            }

            priceWithoutTaxes += currentPrice;
            taxes += currentPrice * 0.20;

            price = scanner.nextLine();
        }

        double totalPrice = taxes + priceWithoutTaxes;
        if (totalPrice == 0) {
            System.out.println("Invalid order!" );
            return;
        }

        if (price.equals("special" )) {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$\n", totalPrice * 0.90);
        } else {
            System.out.println("Congratulations you've just bought a new computer!");
            System.out.printf("Price without taxes: %.2f$\n", priceWithoutTaxes);
            System.out.printf("Taxes: %.2f$\n", taxes);
            System.out.println("-----------");
            System.out.printf("Total price: %.2f$\n", totalPrice);
        }


    }
}
