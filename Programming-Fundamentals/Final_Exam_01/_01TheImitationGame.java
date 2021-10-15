package com.company;

import java.util.Scanner;

public class _01TheImitationGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String message = scanner.nextLine();

        String command = scanner.nextLine();
        while (!command.equals("Decode")) {
            String[] tokens = command.split("\\|");

            switch (tokens[0]) {
                case "Move":
                    int index = Integer.parseInt(tokens[1]);
                    StringBuilder move = new StringBuilder();
                    String substring = message.substring(0,index);
                    move.append(message);
                    move.replace(0,index,"");
                    move.append(substring);
                    message = move.toString();
                    move.setLength(0);
                    break;
                case "Insert":
                    int position = Integer.parseInt(tokens[1]);
                    String letter = tokens[2];
                    StringBuilder insert = new StringBuilder();
                    insert.append(message);
                    insert.insert(position, letter);
                    message = insert.toString();
                    insert.setLength(0);
                    break;
                case "ChangeAll":
                    String oldWord = tokens[1];
                    String newWord = tokens[2];
                    message = message.replace(oldWord,newWord);
                    break;
                default:
                    break;
            }


            command = scanner.nextLine();
        }
        System.out.printf("The decrypted message is: %s", message);


    }


}
