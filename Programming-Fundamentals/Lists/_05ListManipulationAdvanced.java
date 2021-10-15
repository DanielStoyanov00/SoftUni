package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();

            if (line.equals("end")) {
               break;
           }
            String[] lineAsArray = line.split(" ");

            switch (lineAsArray[0]) {
                case "Contains":
                    int number = Integer.parseInt(lineAsArray[1]);
                    if (list.contains(number)) {
                        System.out.println("Yes");
                    } else {
                        System.out.println("No such number");
                    }
                    break;
                case "Print":
                    if (lineAsArray[1].equals("even")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber % 2 == 0) {
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();

                    } else {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber % 2 != 0) {
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;
                case "Get":
                    int sum = 0;
                    for (int i = 0; i < list.size(); i++) {
                        sum += list.get(i);
                    }
                    System.out.print(sum);
                    System.out.println();
                    break;
                case "Filter":
                    String condition = lineAsArray[1];
                    int numberToCompare = Integer.parseInt(lineAsArray[2]);

                    if (condition.equals("<")) {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber < numberToCompare) {
                                System.out.print(currentNumber + " ");
                            }

                        }
                        System.out.println();
                    }else if (condition.equals(">")){
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber > numberToCompare){
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    }else if (condition.equals("<=")){
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber <= numberToCompare){
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    }else {
                        for (int i = 0; i < list.size(); i++) {
                            int currentNumber = list.get(i);
                            if (currentNumber >= numberToCompare){
                                System.out.print(currentNumber + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

            }
        }

    }
}
