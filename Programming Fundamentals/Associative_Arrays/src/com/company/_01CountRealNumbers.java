package com.company;

import java.util.*;

public class _01CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> numbersAndOccurrences = new TreeMap<>();

        Arrays.stream(numbers).forEach(number ->
                numbersAndOccurrences.compute(number, (key, value) ->
                        (value == null) ? 1 : numbersAndOccurrences.get(number) + 1));

        numbersAndOccurrences.forEach((key, value) -> System.out.printf("%.0f -> %d\n", key, value));

    }


}

