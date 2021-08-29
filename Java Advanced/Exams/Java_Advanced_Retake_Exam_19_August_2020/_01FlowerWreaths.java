package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class _01FlowerWreaths {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> stackOfLilies = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .forEach(stackOfLilies::push);

        ArrayDeque<Integer> queueOfRoses = Arrays.stream(scanner.nextLine().split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        int totalSum = 0;
        int wreaths = 0;

        while (!stackOfLilies.isEmpty() || !queueOfRoses.isEmpty()) {
            if (stackOfLilies.isEmpty() || queueOfRoses.isEmpty()) {
                break;
            }
            int lily = stackOfLilies.pop();
            int rose = queueOfRoses.poll();
            int sum = lily + rose;

            if (sum == 15) {
                wreaths++;
            } else if (sum < 15) {
                totalSum += sum;
            } else {
                while (lily + rose > 15) {
                    lily -= 2;
                    if (lily + rose == 15) {
                        wreaths++;
                    } else if (lily + rose < 15) {
                        totalSum += lily + rose;
                    }
                }
            }

        }
        while (totalSum >= 15) {
            wreaths++;
            totalSum -= 15;
        }

        if (wreaths >= 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!", wreaths);
        }else {
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - wreaths);
        }
    }
}
