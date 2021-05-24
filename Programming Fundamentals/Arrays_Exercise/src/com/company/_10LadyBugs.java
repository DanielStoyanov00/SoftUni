package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _10LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] field = new int[Integer.parseInt(scanner.nextLine())];
        int[] indexes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(e -> Integer.parseInt(e)).toArray();
        for (int i = 0; i < indexes.length; i++) {
            if (indexes[i] >= 0 && indexes[i] < field.length) {
                field[indexes[i]] = 1;
            }
        }
        String command;
        while (!(command = scanner.nextLine()).equals("end")) {
            String[] input = command.split(" ");
            int index = Integer.parseInt(input[0]);
            String direction = input[1];
            int flight = Integer.parseInt(input[2]);

            if (index < 0 || index >= field.length || field[index] == 0) {
                continue;
            }
            field[index] = 0;
            int currentFlight = flight;
            if (direction.equals("right")) {
                while (index + currentFlight < field.length && index + currentFlight >= 0) {
                    if (field[index + currentFlight] == 0) {
                        field[index + currentFlight] = 1;
                        break;
                    } else {
                        currentFlight += flight;
                    }
                }
            } else if (direction.equals("left")) {
                while (index - currentFlight >= 0 && index - currentFlight < field.length) {
                    if (field[index - currentFlight] == 0) {
                        field[index - currentFlight] = 1;
                        break;
                    } else {
                        currentFlight += flight;
                    }
                }
            }
        }
        for (int cell : field) {
            System.out.print(cell + " ");
        }

    }
}
