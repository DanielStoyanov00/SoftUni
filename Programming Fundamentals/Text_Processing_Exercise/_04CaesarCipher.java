package com.company;

import java.util.Scanner;

public class _04CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        for (int i = 0; i < line.length(); i++) {
            char currentSymbol = line.charAt(i);

            System.out.print(Character.toChars(currentSymbol + 3));

        }
    }
}
