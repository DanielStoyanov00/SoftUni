package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _01Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int maxQuantityPerWagon = Integer.parseInt(scanner.nextLine());

        List<Integer> wagons = InitialValues(input);

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] array = line.split(" ");

            if (array[0].equals("Add")) {
                wagons.add(Integer.parseInt(array[1]));
            } else {
                for (int i = 0; i < wagons.size(); i++) {
                    if (wagons.get(i) + Integer.parseInt(array[0]) <= maxQuantityPerWagon) {
                        wagons.set(i, wagons.get(i) + Integer.parseInt(array[0]));
                        break;
                    }
                }
            }
            line = scanner.nextLine();

        }
        for (int num : wagons) {
            System.out.print(num + " ");
        }
    }


    public static List<Integer> InitialValues(String input) {

        String[] line = input.split(" ");

        List<Integer> wagons = new ArrayList<>();

        for (String number : line) {
            int num = Integer.parseInt(number);
            wagons.add(num);
        }

        return wagons;
    }
}
