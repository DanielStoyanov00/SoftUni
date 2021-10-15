package com.company;

import java.util.Scanner;

public class _04BitDestroyer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        int position = Integer.parseInt(scanner.nextLine());

        int mask = ~(1 << position);


        int result = (number & mask);

        System.out.println(result);
    }
}
