package com.company;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class _01MagicBox {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] first = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] second = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Deque<Integer> firstAsQueue = new ArrayDeque<>();
        Deque<Integer> secondAsStack = new ArrayDeque<>();

        Arrays.stream(first).forEach(firstAsQueue::offer);
        Arrays.stream(second).forEach(secondAsStack::push);

        int totalSum = 0;

        while (!firstAsQueue.isEmpty() || !secondAsStack.isEmpty()) {
            if (firstAsQueue.isEmpty() || secondAsStack.isEmpty()) {
                break;
            }
            int numFromQueue = firstAsQueue.poll();
            int numFromStack = secondAsStack.pop();
            int sum = numFromQueue + numFromStack;

            if (sum % 2 == 0) {
                totalSum += sum;
            } else {
                firstAsQueue.addFirst(numFromQueue);
                firstAsQueue.offer(numFromStack);
            }
        }
        if (firstAsQueue.isEmpty()) {
            System.out.println("First magic box is empty.");
        } else {
            System.out.println("Second magic box is empty.");
        }

        if (totalSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", totalSum);
        } else {
            System.out.printf("Poor prey... Value: %d", totalSum);
        }

    }
}
