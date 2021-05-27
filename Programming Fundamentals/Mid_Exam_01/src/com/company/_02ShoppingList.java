package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02ShoppingList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> list = Arrays.stream(scanner.nextLine().split("!"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {

            String[] splittedInput = input.split(" ");

            switch (splittedInput[0]) {
                case "Urgent":
                    if (!list.contains(splittedInput[1])) {
                        list.add(0, splittedInput[1]);
                    }
                    break;
                case "Unnecessary":
                    if (list.contains(splittedInput[1])) {
                        list.remove(splittedInput[1]);
                    }
                    break;
                case "Correct":
                    if (list.contains(splittedInput[1])) {
                        list.set(list.indexOf(splittedInput[1]), splittedInput[2]);
                    }
                    break;
                case "Rearrange":
                    if (list.contains(splittedInput[1])) {
                        String item = splittedInput[1];
                        list.remove(item);
                        list.add(item);
                    }
                    break;
            }

            input = scanner.nextLine();
        }


        int counter = 0;
        for (String element : list) {
            counter++;
            if (counter == list.size()) {
                System.out.print(element);
            } else {
                System.out.print(element + ", ");
            }

        }


    }
}
