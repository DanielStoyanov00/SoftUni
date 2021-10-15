package com.company;

import java.util.Scanner;

public class _01CounterStrike {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String command = scanner.nextLine();
        int countWin = 0;
        while (!command.equals("End of battle")) {
            int distance = Integer.parseInt(command);
            if (initialEnergy < distance) {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", countWin, initialEnergy);
                return;
            }
            initialEnergy -= distance;
            countWin++;
            if (countWin % 3 == 0) {
                initialEnergy += countWin;
            }
            command = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", countWin, initialEnergy);
    }


}

