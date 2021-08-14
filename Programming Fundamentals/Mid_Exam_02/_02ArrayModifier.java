package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOfNumbers = scanner.nextLine();
        int[] array = parseArray(lineOfNumbers);


        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] lineAsArray = line.split(" ");

            switch (lineAsArray[0]) {

                case "swap":
                    swap(array, Integer.parseInt(lineAsArray[1]), Integer.parseInt(lineAsArray[2]));
                    break;
                case "multiply":
                    multiply(array, Integer.parseInt(lineAsArray[1]), Integer.parseInt(lineAsArray[2]));
                    break;
                case "decrease":
                    decrease(array);
                    break;
            }

            line = scanner.nextLine();
        }

        printArray(", ", array);


    }

    private static void swap(int[] array, int indexA, int indexB) {
        int oldA = array[indexA];
        array[indexA] = array[indexB];
        array[indexB] = oldA;
    }

    private static void multiply(int[] array, int indexA, int indexB) {
        array[indexA] = array[indexA] * array[indexB];
    }

    private static void decrease(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i]--;
        }
    }


    public static int[] parseArray(String line) {
        String[] numberAsString = line.split(" ");
        int[] array = new int[numberAsString.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numberAsString[i]);
        }

        return array;


    }

    static void printArray(String separator, int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(separator);
            }

        }
        System.out.println();

    }


}
