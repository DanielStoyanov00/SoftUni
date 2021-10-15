package com.company;

import java.util.Scanner;

public class _01NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalPeoplePerHour = Integer.parseInt(scanner.nextLine()) + Integer.parseInt(scanner.nextLine()) + Integer.parseInt(scanner.nextLine());
        int totalPeople = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        while (totalPeople > 0) {

            hours++;
            if (hours % 4 != 0) {
                totalPeople -= totalPeoplePerHour;
            }
        }
        System.out.printf("Time needed: %dh.", hours);


    }
}
