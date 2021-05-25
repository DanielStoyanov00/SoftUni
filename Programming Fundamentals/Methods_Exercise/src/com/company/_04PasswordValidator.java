package com.company;

import java.util.Scanner;

public class _04PasswordValidator {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        boolean passIsValid = true;


        if (!checkIfLengthLegal(input)) {
            passIsValid = false;
        }
        if (!checkForSymbols(input)) {
            passIsValid = false;
        }
        if (!checkForDigits(input)) {
            passIsValid = false;
        }
        if (passIsValid) {
            System.out.println("Password is valid");
        }

    }


    static boolean checkIfLengthLegal(String input) {
        if (input.length() >= 6 && input.length() <= 10) {

            return true;
        } else {
            System.out.println("Password must be between 6 and 10 characters");
            return false;
        }
    }

    static boolean checkForSymbols(String input) {
        boolean isLegal = false;

        for (int i = 0; i < input.length(); i++) {
            int letter = input.charAt(i);

            if (letter >= '0' && letter <= '9') {
                isLegal = true;
            } else if (letter >= 'A' && letter <= 'Z') {
                isLegal = true;
            } else if (
                    letter >= 'a' && letter <= 'z') {
                isLegal = true;
            } else {
                isLegal = false;
                break;
            }

        }
        if (!isLegal) {
            System.out.println("Password must consist only of letters and digits");
            return false;
        } else {
            return true;
        }
    }

    static boolean checkForDigits(String input) {
        int digitCounter = 0;
        for (int i = 0; i < input.length(); i++) {
            int charA = input.charAt(i);
            if (charA >= '0' && charA <= '9') {
                digitCounter++;
            }
        }
        if (digitCounter < 2) {
            System.out.println("Password must have at least 2 digits");
            return false;
        } else {
            return true;
        }
    }
}
