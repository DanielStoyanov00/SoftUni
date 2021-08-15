package com.company;

import java.util.Scanner;
import java.util.function.Function;

public class _02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        int sum = 0;
        for (String current : input){
            int num = parser.apply(current);
            sum += num;
        }

        System.out.printf("Count = %d\n", input.length);
        System.out.printf("Sum = %d", sum);
    }
}