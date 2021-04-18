package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SumAdjacentEqualNumbers1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Double> numbers = parseLineOfNumbers(scanner);

        boolean search = true;
        while (search) {
            search = false;

            for (int i = 0; i < numbers.size() - 1; i++) {
                double current = numbers.get(i);
                double next = numbers.get(i + 1);
                if (current == next) {
                    numbers.remove(i);
                    numbers.set(i, current + next);
                    search = true;
                    break;
                }
            }
        }

        for (double number : numbers) {
            if (number >= 0 && number <= 0.99 ){
                System.out.printf("%.1f ", number);
            }else {
                System.out.printf("%.0f ", number);
            }
        }

    }

    public static List<Double> parseLineOfNumbers(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsArray = line.split(" ");

        ArrayList<Double> numbers = new ArrayList<>();

        for (String s : lineAsArray) {
            double number = Double.parseDouble(s);
            numbers.add(number);
        }

        return numbers;

    }


}
