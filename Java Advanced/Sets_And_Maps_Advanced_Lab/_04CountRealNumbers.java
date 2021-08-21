package com.company;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Double, Integer> numbersCount = new LinkedHashMap<>();

        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double number : numbers) {
            if (!numbersCount.containsKey(number)) {
                numbersCount.put(number, 1);
            } else {
                numbersCount.put(number, numbersCount.get(number) + 1);
            }
        }


       numbersCount.forEach((key, value) -> System.out.printf("%.1f -> %d\n", key, value));






    }
}
