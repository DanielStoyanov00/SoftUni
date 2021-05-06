package com.company;

import java.util.Scanner;

public class FirstBit2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        int mask = 1 << 1;

        int result = (number & mask) >> 1;
        System.out.println(result);

    }
}
