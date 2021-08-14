package com.company;

import java.util.Scanner;

public class _04PrintAndSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int endNumber = Integer.parseInt(scanner.nextLine());

        int sum = 0;

        for (int i = startNumber; i <= endNumber ; i++) {
            sum += i;
            System.out.print(i + " ");
        }
        System.out.println(System.lineSeparator() + "Sum: " + sum);


    }
}
