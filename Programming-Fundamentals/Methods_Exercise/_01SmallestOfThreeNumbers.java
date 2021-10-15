package com.company;

import java.util.Scanner;

public class _01SmallestOfThreeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());

        int min = Math.min(first, Math.min(second,third));
        System.out.println(min);
    }
}
