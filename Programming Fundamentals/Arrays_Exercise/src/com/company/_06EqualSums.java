package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _06EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(e -> Integer.parseInt(e)).toArray();
        if (numbers.length < 1) {
            System.out.print(0);
            return;
        }

        boolean isEquals = false;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            //leftSum
            for (int j = i - 1; j >= 0; j--) {
                leftSum += numbers[j];
            }

            //rightSum
            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }
            if (leftSum == rightSum) {
                isEquals = true;
                System.out.print(i + " ");
                break;
            }
        }
        if (!isEquals) {
            System.out.print("no");

        }


    }


}

