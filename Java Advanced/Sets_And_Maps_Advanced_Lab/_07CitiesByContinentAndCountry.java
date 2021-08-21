package com.company;

import java.util.*;

public class _07CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Map<String, List<String>>> cities = new LinkedHashMap<>();

        int numberOfOperations = Integer.parseInt(scanner.nextLine());
        while (numberOfOperations-- > 0) {
            String[] info = scanner.nextLine().split("\\s+");

            cities.putIfAbsent(info[0], new LinkedHashMap<>());
            cities.get(info[0]).putIfAbsent(info[1], new ArrayList<>());
            cities.get(info[0]).get(info[1]).add(info[2]);
        }

        cities.forEach((key,value) ->{
            System.out.println(key + ":");
            value.forEach((innerKey, innerValue) -> {
                System.out.println("  " + innerKey + " -> "
                        + String.join(", ", innerValue));
            });
        });
    }
}
