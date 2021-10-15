package com.company;

import java.util.Scanner;

public class ReverseArrayOfStrings4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] elements = input.split(" ");


        for (int i = 0; i < elements.length; i++) {
            System.out.print(elements[elements.length - 1 - i] + " ");

        }

    }
}
