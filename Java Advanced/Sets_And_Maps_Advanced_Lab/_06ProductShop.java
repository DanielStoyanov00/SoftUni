package com.company;
import java.util.*;

public class _06ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, Double>> products = new TreeMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Revision")) {
            String[] tokens = input.split(", ");

            products.putIfAbsent(tokens[0], new LinkedHashMap<>());
            products.get(tokens[0]).put(tokens[1], Double.parseDouble(tokens[2]));

            input = scanner.nextLine();
        }

        products.entrySet()
                .stream()
                .forEach(entry -> {
                    System.out.println(entry.getKey() + "->");
                    entry.getValue().entrySet()
                            .stream()
                            .forEach(innerEntry -> {
                                System.out.printf("Product: %s, Price: %.1f\n",
                                        innerEntry.getKey(), innerEntry.getValue());
                            });
                });
    }
}
