package com.company;

import java.util.Scanner;

public class _01BlackFlag {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        double dailyPlunder = Double.parseDouble(scanner.nextLine());
        double expectedPlunder = Double.parseDouble(scanner.nextLine());

        double totalPlunder = 0;

        for (int i = 1; i <= days; i++) {
            totalPlunder += dailyPlunder;

            if (i % 3 == 0) {
                totalPlunder += dailyPlunder / 2;
            }
            if (i % 5 == 0) {
                totalPlunder -= totalPlunder * 0.3;
            }
        }

        if (totalPlunder >= expectedPlunder) {
            System.out.printf("Ahoy! %.2f plunder gained.", totalPlunder);
        } else {
            System.out.printf("Collected only %.2f%% of the plunder.", (totalPlunder / expectedPlunder) * 100);
        }

    }
}
