package com.company;

import java.util.Scanner;

public class _02MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split("\\|");

        int health = 100;
        int amountOfBitcoins = 0;
        int roomCounter = 0;
        boolean survive = true;

        for (int i = 0; i < input.length; i++) {
            String[] action = input[i].split(" ");
            roomCounter++;

            if (action[0].equals("potion")) {
                int heal = Integer.parseInt(action[1]);
                if (heal + health <= 100) {
                    health += heal;
                    System.out.printf("You healed for %d hp.\n", heal);
                    System.out.printf("Current health: %d hp.\n", health);
                } else {
                    int healed = Math.abs(((heal + health) - 100) - heal);
                    health = 100;
                    System.out.printf("You healed for %d hp.\n", healed);
                    System.out.printf("Current health: %d hp.\n", health);
                }
            } else if (action[0].equals("chest")) {
                int bitcoins = Integer.parseInt(action[1]);
                System.out.printf("You found %d bitcoins.\n", bitcoins);
                amountOfBitcoins += bitcoins;
            } else {
                String creature = action[0];
                int damage = Integer.parseInt(action[1]);

                if (health - damage > 0) {
                    System.out.printf("You slayed %s.\n", creature);
                    health -= damage;
                } else {
                    System.out.printf("You died! Killed by %s.\n", creature);
                    System.out.printf("Best room: %d", roomCounter);
                    survive = false;
                    break;
                }
            }

        }
        if (survive) {
            System.out.printf("You've made it!\nBitcoins: %d\nHealth: %d", amountOfBitcoins, health);

        }
    }
}
