package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _04ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Integer> list = parseLineOfNumbers(line);


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] inputAsArray = input.split("\\s+");


            if (inputAsArray[0].equals("Add")) {
                int numberToAdd = Integer.parseInt(inputAsArray[1]);
                list.add(numberToAdd);
            } else if (inputAsArray[0].equals("Remove")) {
                int indexToRemove = Integer.parseInt(inputAsArray[1]);
                if (indexToRemove >= list.size() || indexToRemove < 0) {
                    System.out.println("Invalid index");
                } else {
                    list.remove(indexToRemove);
                }

            } else if (inputAsArray[0].equals("Insert")) {
                int numberToInsert = Integer.parseInt(inputAsArray[1]);
                int indexToInsert = Integer.parseInt(inputAsArray[2]);
                if (indexToInsert > list.size() || indexToInsert < 0) {
                    System.out.println("Invalid index");

                } else {
                    list.add(indexToInsert, numberToInsert);

                }
            } else if (inputAsArray[1].equals("left")) {
                int numberToShiftLeft = Integer.parseInt(inputAsArray[2]);


                for (int i = 0; i < numberToShiftLeft; i++) {
                    list.add(list.get(0));
                    list.remove(0);
                }

            } else {
                int numberToShiftRight = Integer.parseInt(inputAsArray[2]);

                for (int i = 0; i < numberToShiftRight; i++) {

                    list.add(0, list.get(list.size() - 1));
                    list.remove(list.size() - 1);


                }

            }


        }
        for (double number : list) {
            System.out.printf("%.0f ", number);
        }


    }

    public static List<Integer> parseLineOfNumbers(String line) {

        String[] lineAsArray = line.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String s : lineAsArray) {
            int number = Integer.parseInt(s);
            list.add(number);
        }
        return list;
    }

}


