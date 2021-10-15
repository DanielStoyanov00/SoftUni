package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01ParkingLot {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> cars = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(", ");

            switch (tokens[0]) {
                case "IN":
                    String lotToAdd = tokens[1];
                    cars.add(lotToAdd);
                    break;
                case "OUT":
                    String lotToRemove = tokens[1];
                    cars.remove(lotToRemove);
                    break;
                default:
                    break;
            }
            input = scanner.nextLine();
        }

        if (cars.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            System.out.print(String.join(System.lineSeparator(), cars));
        }
    }
}
