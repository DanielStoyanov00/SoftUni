package com.company;

import java.util.Scanner;

public class _05Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String password = "";

        for (int i = username.length() - 1; i >= 0; i--) {
            password += username.charAt(i);
        }

        int counter = 0;
        String input = scanner.nextLine();
        while (!input.equals(password)) {

            if (input.equals(password)) {
                System.out.printf("User %s logged in.\n", username);
                break;
            } else {
                counter++;
                if (counter == 4) {
                    System.out.printf("User %s blocked!\n", username);
                    break;
                }
            }
            if (!input.equals(password) && counter < 4) {
                System.out.println("Incorrect password. Try again.");
            }


            input = scanner.nextLine();
        }
        if (input.equals(password)) {
            System.out.printf("User %s logged in.", username);
        }


    }
}
