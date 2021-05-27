package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());


        String line = scanner.nextLine();

        while (!line.equals("End")) {
            String[] splittedLine = line.split(" ");

            switch (splittedLine[0]) {
                case "Shoot":
                    int index = Integer.parseInt(splittedLine[1]);
                    int power = Integer.parseInt(splittedLine[2]);
                    if (index >= 0 && index < list.size()) {
                        list.set(index, list.get(index) - power);
                        if (list.get(index) <= 0) {
                            list.remove(index);
                        }
                    }
                    break;
                case "Add":
                    int indeX = Integer.parseInt(splittedLine[1]);
                    int value = Integer.parseInt(splittedLine[2]);
                    if (indeX >= 0 && indeX < list.size()) {
                        list.add(indeX, value);
                    } else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int place = Integer.parseInt(splittedLine[1]);
                    int radius = Integer.parseInt(splittedLine[2]);

                    if (place >= 0 && place < list.size()) {
                        if (place - radius >= 0 && place + radius < list.size()) {
                            for (int i = place + radius; i >= place - radius; i--) {
                                list.remove(i);
                            }
                        } else {
                            System.out.println("Strike missed!");
                        }
                    }

                    break;

            }
            line = scanner.nextLine();
        }

        int counter = 0;
        for (int number : list) {
            counter++;
            if (counter == list.size()) {
                System.out.print(number);
            } else {

                System.out.print(number + "|");
            }
        }


    }
}
