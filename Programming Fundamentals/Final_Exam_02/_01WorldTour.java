package com.company;

import java.util.Scanner;

public class _01WorldTour {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();



        String command = scanner.nextLine();
        while (!command.equals("Travel")){
            String[] tokens = command.split(":");

            switch (tokens[0]){
                case "Add Stop":
                    int index = Integer.parseInt(tokens[1]);
                    String stringToInsert = tokens[2];
                    StringBuilder builder = new StringBuilder();
                    if (index >= 0 && index < input.length()){
                        builder.append(input);
                        builder.insert(index, stringToInsert);
                    }
                    input = builder.toString();
                    System.out.println(input);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (startIndex >= 0 && startIndex < input.length() && endIndex >= 0 && endIndex < input.length()){
                        StringBuilder remove = new StringBuilder();
                        remove.append(input);
                        remove.replace(startIndex, endIndex + 1, "");
                        input = remove.toString();
                    }
                    System.out.println(input);
                    break;
                case "Switch":
                    String oldString = tokens[1];
                    String newString = tokens[2];
                    if (input.contains(oldString)){
                        input = input.replace(oldString, newString);
                    }
                    System.out.println(input);
                    break;


            }



            command = scanner.nextLine();
        }
        System.out.printf("Ready for world tour! Planned stops: %s", input);
    }
}
