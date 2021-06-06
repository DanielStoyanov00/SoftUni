package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _03ManOWar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] pirateShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();
        int[] warShip = Arrays.stream(scanner.nextLine().split(">"))
                .mapToInt(Integer::parseInt).toArray();

        int maximumHealth = Integer.parseInt(scanner.nextLine());


        String command = scanner.nextLine();
        while (!command.equals("Retire")) {
            String[] tokens = command.split(" ");

            switch (tokens[0]) {
                case "Fire":
                    int index = Integer.parseInt(tokens[1]);
                    int damage = Integer.parseInt(tokens[2]);

                    if (index >= 0 && index < warShip.length) {
                        warShip[index] -= damage;
                        if (warShip[index] <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    int damagePerIndex = Integer.parseInt(tokens[3]);

                    if (startIndex >= 0 && startIndex < pirateShip.length
                            && endIndex >= 0 && endIndex < pirateShip.length) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            pirateShip[i] -= damagePerIndex;
                            if (pirateShip[i] <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                        }
                    }
                    break;
                case "Repair":
                    int healIndex = Integer.parseInt(tokens[1]);
                    int health = Integer.parseInt(tokens[2]);

                    if (healIndex >= 0 && healIndex < pirateShip.length) {
                        if (pirateShip[healIndex] + health > maximumHealth) {
                            pirateShip[healIndex] = maximumHealth;
                        } else {
                            pirateShip[healIndex] += health;
                        }
                    }
                    break;
                case "Status":
                    int counter = 0;
                    double percentage = maximumHealth * 0.20;
                    for (int i = 0; i < pirateShip.length; i++) {
                        if (pirateShip[i] < percentage) {
                            counter++;
                        }
                    }
                    System.out.printf("%d sections need repair.\n", counter);
                    break;

            }


            command = scanner.nextLine();
        }
        int sumOfPirateHealth = 0;
        for (int pirate : pirateShip) {
            sumOfPirateHealth += pirate;
        }
        int sumOfWarShipHealth = 0;
        for (int war : warShip) {
            sumOfWarShipHealth += war;
        }
        System.out.printf("Pirate ship status: %d\n", sumOfPirateHealth);
        System.out.printf("Warship status: %d", sumOfWarShipHealth);

    }
}
