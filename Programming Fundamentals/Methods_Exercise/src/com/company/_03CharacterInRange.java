package com.company;

import java.util.Scanner;

public class _03CharacterInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstSymbol = scanner.nextLine();
        String secondSymbol = scanner.nextLine();

        symbolsBetween(firstSymbol, secondSymbol);


    }


    static void symbolsBetween(String firstSymbol, String secondSymbol) {

        int start = firstSymbol.charAt(0);
        int end = secondSymbol.charAt(0);

        if (start < end) {
            for (int i = start + 1; i < end; i++) {
                char currentSymbol = ((char) i);
                System.out.print(currentSymbol + " ");
            }
        } else {
            for (int i = end + 1; i < start; i++) {
                char currentLetter = ((char) i);
                System.out.print(currentLetter + " ");
            }
        }

    }
}
