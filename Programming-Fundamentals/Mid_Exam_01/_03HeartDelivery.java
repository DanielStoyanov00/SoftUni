package com.company;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03HeartDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split("@");
        List<Integer> list = parseLineOfNumbers(array);

        int lastIndex = 0;

        String line = scanner.nextLine();
        while (!line.equals("Love!")) {

            String[] splitLine = line.split(" ");
            int index = Integer.parseInt(splitLine[1]);

            lastIndex += index;
            if (lastIndex >= list.size()) {
                lastIndex = 0;
            }

            if (index < list.size() && index >= 0) {
                if (lastIndex < list.size()) {
                    if (list.get(lastIndex) == 0) {
                        System.out.printf("Place %d already had Valentine's day.\n", lastIndex);
                    } else {
                        list.set(lastIndex, list.get(lastIndex) - 2);
                        if (list.get(lastIndex) == 0) {
                            System.out.printf("Place %d has Valentine's day.\n", lastIndex);
                        }
                    }

                }
            } else {
                lastIndex = 0;
                if (list.get(0) == 0) {
                    System.out.printf("Place %d already had Valentine's day.\n", lastIndex);
                } else {
                    list.set(0, list.get(0) - 2);
                    if (list.get(lastIndex) == 0) {
                        System.out.printf("Place %d has Valentine's day.\n", lastIndex);
                    }
                }

            }
            line = scanner.nextLine();
        }

        System.out.printf("Cupid's last position was %d.\n", lastIndex);
        int failedTimesCounter = 0;

        for (int houseHearts : list) {
            if (houseHearts != 0) {
                failedTimesCounter++;
            }
        }
        if (failedTimesCounter != 0) {
            System.out.printf("Cupid has failed %d places.", failedTimesCounter);
        } else {
            System.out.println("Mission was successful.");
        }

    }


    static List<Integer> parseLineOfNumbers(String[] array) {

        List<Integer> list = new ArrayList<>();

        for (String string : array) {
            int number = Integer.parseInt(string);
            list.add(number);
        }
        return list;

    }
}
