package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01LootBox {

    public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBoxAsQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new));

        ArrayDeque<Integer> secondBoxStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(secondBoxStack::push);

        int totalSum = 0;

        while (!firstBoxAsQueue.isEmpty() || !secondBoxStack.isEmpty()){
            if (firstBoxAsQueue.isEmpty() || secondBoxStack.isEmpty()){
                break;
            }

            int first = firstBoxAsQueue.poll();
            int second = secondBoxStack.pop();
            int sum = first + second;

            if (sum % 2 == 0){
                totalSum+=sum;
            }else {
                firstBoxAsQueue.offerFirst(first);
                firstBoxAsQueue.offer(second);
            }
        }

        if (firstBoxAsQueue.isEmpty()){
            System.out.println("First lootbox is empty");
        }else {
            System.out.println("Second lootbox is empty");
        }

        if (totalSum >= 100){
            System.out.printf("Your loot was epic! Value: %d", totalSum);
        }else {
            System.out.printf("Your loot was poor... Value: %d", totalSum);
        }


    }
}
