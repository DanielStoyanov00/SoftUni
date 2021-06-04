package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _02TheLift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        int[] wagons = Arrays.stream(scanner.nextLine().split(" " ))
                .mapToInt(Integer::parseInt).toArray();


        for (int i = 0; i < wagons.length; i++) {

            for (int j = wagons[i]; j <= 4 ; j++) {
                if (wagons[i] < 4 && numberOfPeople > 0){
                    wagons[i]++;
                    numberOfPeople--;
                    if (wagons[i] == 4){
                        break;
                    }
                }

            }

        }
        for (int i = 0; i < wagons.length; i++) {

            if (numberOfPeople == 0 && wagons[i] < 4) {
                System.out.println("The lift has empty spots!");
                for (int wagon : wagons) {
                    System.out.print(wagon + " " );
                }
                return;
            } else if (numberOfPeople > 0 && wagons[wagons.length - 1] == 4) {
                System.out.printf("There isn't enough space! %d people in a queue!\n", numberOfPeople);
                for (int wagon : wagons) {
                    System.out.print(wagon + " ");
                }
                return;
            } else if (numberOfPeople == 0 && wagons[wagons.length - 1] == 4) {
                for (int wagon : wagons) {
                    System.out.print(wagon + " ");
                }
                return;
            }
        }


    }
}
