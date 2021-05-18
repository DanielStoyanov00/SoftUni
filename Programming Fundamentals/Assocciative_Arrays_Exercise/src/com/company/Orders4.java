package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("buy")) {
            String[] array = input.split(" ");
            String product = array[0];
            double pricePerOne = Double.parseDouble(array[1]);
            int quantity = Integer.parseInt(array[2]);

            productsPrice.put(product, pricePerOne);
            if (!productsQuantity.containsKey(product)){
                productsQuantity.put(product, quantity);
            }else {
                productsQuantity.put(product, productsQuantity.get(product) + quantity);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Double> entry : productsPrice.entrySet()) {
            double totalPrice = entry.getValue() * productsQuantity.get(entry.getKey());
            System.out.printf("%s -> %.2f%n", entry.getKey(), totalPrice);
        }


    }
}
