package com.company;

import java.util.Scanner;

public class _01BonusScoringSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double lectures = Double.parseDouble(scanner.nextLine());
        int bonus = Integer.parseInt(scanner.nextLine());

        double maxPoints = 0;
        int maxAttendances = 0;

        for (int i = 0; i < numberOfStudents; i++) {
            int attendances = Integer.parseInt(scanner.nextLine());

            double totalBonus = (attendances / lectures) * (5 + bonus);
            if (totalBonus > maxPoints) {
                maxPoints = totalBonus;
            }

            if (attendances > maxAttendances) {
                maxAttendances = attendances;
            }

        }

        System.out.printf("Max Bonus: %.0f.\n", Math.ceil(maxPoints));
        System.out.printf("The student has attended %d lectures.", maxAttendances);

    }
}
