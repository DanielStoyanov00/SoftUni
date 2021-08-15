package com.company;

import java.util.*;
import java.util.function.Function;

public class _04AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Double, Double> addedVat = e -> e * 1.20;

        double[] numbersAsString = Arrays.stream(scanner.nextLine().split(", "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        System.out.println("Prices with VAT:");
        Arrays.stream(numbersAsString)
                .boxed()
                .map(addedVat)
                .forEach(priceWithAddedVat -> {
                    System.out.printf("%.2f\n", priceWithAddedVat);
                });
    }
}