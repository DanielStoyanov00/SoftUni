package com.company;

import java.util.Scanner;

public class _010RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int headsetCount = 0;
        int mouseCount = 0;
        int keyboardCount = 0;
        int displayCount = 0;
        double totalPrice = 0;

        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                headsetCount++;
            }
            if (i % 3 == 0) {
                mouseCount++;
            }
            if (i % 3 == 0 && i % 2 == 0) {
                keyboardCount++;
                if (keyboardCount % 2 == 0) {
                    displayCount++;
                }
            }
        }

        totalPrice = headsetCount * headsetPrice + mouseCount * mousePrice + keyboardCount * keyboardPrice + displayCount * displayPrice;

        System.out.printf("Rage expenses: %.2f lv.", totalPrice);

    }

    }

