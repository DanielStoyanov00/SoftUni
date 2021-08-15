package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _03CountsUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Predicate<String> startsWithUpperCase = e -> Character.isUpperCase(e.charAt(0));

        String[] text = scanner.nextLine().split("\\s+");

        List<String> wordsThatStartsWithUppercase = Arrays.stream(text)
                .filter(startsWithUpperCase)
                .collect(Collectors.toList());

        System.out.println(wordsThatStartsWithUppercase.size());
        wordsThatStartsWithUppercase.forEach(System.out::println);
    }
}