package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < number; i++) {
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile("@([#]+)(?<name>[A-Z][A-Za-z\\d]{4,}[A-Z])@([#]+)");
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String barcode = matcher.group("name");
                StringBuilder concat = new StringBuilder();
                System.out.print("Product group: ");
                for (int j = 0; j < barcode.length(); j++) {
                    char symbol = barcode.charAt(j);
                    if (Character.isDigit(symbol)) {
                        concat.append(symbol);
                    }
                }
                if (concat.length() != 0) {
                    System.out.print(concat);
                } else if (concat.length() == 0) {
                    System.out.print("00");
                } else {
                    System.out.println("Invalid barcode");
                }
                concat.setLength(0);
                System.out.println();
            } else {
                System.out.println("Invalid barcode");
            }
        }


    }

}

