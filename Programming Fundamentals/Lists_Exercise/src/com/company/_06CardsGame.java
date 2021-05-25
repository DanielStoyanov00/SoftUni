package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _06CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> firstCard = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> secondCard = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        while (!firstCard.isEmpty() || !secondCard.isEmpty()) {

            if (firstCard.isEmpty() || secondCard.isEmpty()) {
                break;
            }

            int first = firstCard.get(0);
            int second = secondCard.get(0);

            if (first == second) {
                firstCard.remove(0);
                secondCard.remove(0);
            } else if (first > second) {
                firstCard.remove(0);
                secondCard.remove(0);
                firstCard.add(first);
                firstCard.add(second);
            } else {
                secondCard.remove(0);
                firstCard.remove(0);
                secondCard.add(second);
                secondCard.add(first);
            }

        }
        int sum = 0;
        if (!firstCard.isEmpty()) {
            for (int number : firstCard) {
                sum += number;
            }
            System.out.printf("First player wins! Sum: %d", sum);
        } else {
            for (int number : secondCard) {
                sum += number;
            }
            System.out.printf("Second player wins! Sum: %d", sum);
        }


    }
}



