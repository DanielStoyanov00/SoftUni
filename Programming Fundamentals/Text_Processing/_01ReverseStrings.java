package com.company;

import java.util.Scanner;

public class ReverseStrings1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            StringBuilder reversed = new StringBuilder();

            for (int i = 0; i < line.length(); i++) {
                reversed.append(line.charAt(i));
            }

            System.out.println(line + " = " + reversed.reverse());
            line = scanner.nextLine();

        }

    }
}
