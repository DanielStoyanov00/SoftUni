package com.company;

import java.util.Scanner;

public class SoftUniReception1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int studentsPerOur = scanner.nextInt() + scanner.nextInt() + scanner.nextInt();
        int remainStudents = scanner.nextInt();

        int hours = 0;

        while (remainStudents > 0) {
            hours++;

            if (hours % 4 != 0){
                remainStudents -= studentsPerOur;
            }

        }
        System.out.printf("Time needed: %dh.", hours);


    }
}
