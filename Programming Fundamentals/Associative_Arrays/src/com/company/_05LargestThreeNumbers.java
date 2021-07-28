package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _05LargestThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Arrays.stream(scanner.nextLine().split("\\s+"))
        .map(Integer::parseInt)
        .sorted(Comparator.reverseOrder())
        .limit(3)
        .forEach(number -> System.out.print(number + " "));


    }
}
