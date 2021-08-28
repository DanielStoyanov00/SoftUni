package com.company;

import java.util.*;

public class _01Bouquets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tulips = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] daffodils = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> stackOfTulips = new ArrayDeque<>();
        ArrayDeque<Integer> queueOfDaffodils = new ArrayDeque<>();

        Arrays.stream(tulips).forEach(stackOfTulips::push);
        Arrays.stream(daffodils).forEach(queueOfDaffodils::offer);

        int bouquets = 0;
        int sumOfFlowersBelow15 = 0;

        while (bouquets < 5 || (!stackOfTulips.isEmpty() || !queueOfDaffodils.isEmpty())) {
            if (stackOfTulips.isEmpty() || queueOfDaffodils.isEmpty()) {
                break;
            }
            int tulip = stackOfTulips.pop();
            int daffodil = queueOfDaffodils.poll();

            if (tulip + daffodil == 15) {
                bouquets++;
            } else if (tulip + daffodil < 15) {
                sumOfFlowersBelow15 += tulip + daffodil;
            } else if (tulip + daffodil > 15) {
                while (tulip + daffodil > 15) {
                    tulip -= 2;
                    if (tulip + daffodil == 15) {
                        bouquets++;
                    } else if (tulip + daffodil < 15) {
                        sumOfFlowersBelow15 += tulip + daffodil;
                    }
                }
            }

        }
        while (sumOfFlowersBelow15 >= 15) {
            sumOfFlowersBelow15 -= 15;
            bouquets++;
        }
        if (bouquets >= 5){
            System.out.printf("You made it! You go to the competition with %d bouquets!", bouquets);
        }else {
            System.out.printf("You failed... You need more %d bouquets.", 5 - bouquets);
        }


    }
}
