package com.company;

import java.util.Scanner;

public class _01SecretChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();


        String commands = scanner.nextLine();
        while (!commands.equals("Reveal")) {
            String[] tokens = commands.split(":\\|:");
            String action = tokens[0];

            switch (action) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    stringBuilder.append(input);
                    stringBuilder.insert(index, " ");
                    input = stringBuilder.toString();
                    stringBuilder.setLength(0);
                    System.out.println(input);
                    break;
                case "Reverse":
                    String subString = tokens[1];
                    if (!input.contains(subString)) {
                        System.out.println("error");
                    } else {
                        StringBuilder reversed = new StringBuilder();
                        reversed.append(subString).reverse();
                        input = input.replaceFirst(subString, "");
                        stringBuilder.append(input);
                        stringBuilder.append(reversed);
                        input = stringBuilder.toString();
                        stringBuilder.setLength(0);
                        System.out.println(input);
                    }
                    break;
                case "ChangeAll":
                    String oldSymbol = tokens[1];
                    String newSymbol = tokens[2];
                    if (input.contains(oldSymbol)){
                        input = input.replace(oldSymbol, newSymbol);
                        System.out.println(input);
                    }
                    break;
                default:
                    break;
            }


            commands = scanner.nextLine();
        }
        System.out.printf("You have a new text message: %s", input);

    }
}
