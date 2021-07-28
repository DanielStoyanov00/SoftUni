package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04WordFilter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> words = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        words.stream()
                .filter(word -> word.length() % 2 == 0)
                .forEach(System.out::println);
    }
}
