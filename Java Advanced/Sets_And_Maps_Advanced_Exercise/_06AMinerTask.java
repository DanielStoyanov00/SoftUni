package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> oreAndQuantity = new LinkedHashMap<>();

        String resource = scanner.nextLine();
        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());
            if (!oreAndQuantity.containsKey(resource)){
                oreAndQuantity.put(resource, quantity);
            }else {
            oreAndQuantity.put(resource, oreAndQuantity.get(resource) + quantity);
            }


            resource = scanner.nextLine();
        }
        oreAndQuantity.entrySet().forEach(ore -> {
            System.out.printf("%s -> %d\n", ore.getKey(), ore.getValue());
        });

    }
}
