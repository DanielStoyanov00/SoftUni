package com.company;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(i -> Double.parseDouble(i))
                .toArray();

        TreeMap<Double, Integer> counts = new TreeMap<>();

        for (Double number : numbers){
            if (!counts.containsKey(number)){
                counts.put(number,0);
            }
            counts.put(number, counts.get(number) + 1);
        }

        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%.0f -> %d%n", entry.getKey(), entry.getValue());
        }


    }
}
