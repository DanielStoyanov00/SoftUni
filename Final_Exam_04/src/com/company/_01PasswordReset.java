package com.company;

import java.util.Scanner;

public class _01PasswordReset {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        StringBuilder stringBuilder = new StringBuilder();

        String command = scanner.nextLine();
        while (!command.equals("Done")){
            String[] tokens = command.split(" ");
            String action = tokens[0];

            switch (action){
                case "TakeOdd":
                    for (int i = 0; i < input.length(); i++) {
                        if (i % 2 != 0){
                            stringBuilder.append(input.charAt(i));
                        }
                    }
                    input = stringBuilder.toString();
                    stringBuilder.setLength(0);
                    System.out.println(input);
                    break;
                case "Cut":
                    int index = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    stringBuilder.append(input);
                    stringBuilder.replace(index,length + index,"");
                    input = stringBuilder.toString();
                    stringBuilder.setLength(0);
                    System.out.println(input);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (input.contains(substring)){
                        input = input.replace(substring, substitute);
                        System.out.println(input);
                    }else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
                default:
                    break;
            }




            command = scanner.nextLine();
        }
        System.out.printf("Your password is: %s", input);

    }
}
