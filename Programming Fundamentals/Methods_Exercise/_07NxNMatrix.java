package com.company;

import java.util.Scanner;

public class _07NxNMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        matrix(number);
    }

    static void matrix(int number) {

        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                System.out.print(number + " ");

            }
            System.out.println();

        }
    }
}
