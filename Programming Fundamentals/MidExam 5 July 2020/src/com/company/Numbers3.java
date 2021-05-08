package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOfNumbers = scanner.nextLine();

        int[] array = parseLine(lineOfNumbers);
        double averageNumber = averageNumber(array);


        List<Integer> numbers = new ArrayList<>();
        for (int number : array) {
            if (number > averageNumber){
                numbers.add(number);
            }
        }

        if (numbers.isEmpty()){
            System.out.println("No");
        }else {
            Collections.sort(numbers);
            Collections.reverse(numbers);
        }


        // Math.min(numbers.size(), 5) is equal to:
        // Math.min get the size of list and if it greater than 5, it breaks;

        // int counter = 0; And when we print number in for cycle: counter ++; if (count >= 5) {break};

        for (int i = 0; i < Math.min(numbers.size(), 5); i++) {
            System.out.print(numbers.get(i) + " ");
        }


    }


    private static int[] parseLine (String lineOfNumbers){
        String[] numbersAsString = lineOfNumbers.split(" ");

        int[] array = new int[numbersAsString.length];

        for (int i = 0; i < array.length; i++) {
            array[i] = Integer.parseInt(numbersAsString[i]);
        }

        return array;

    }

    private static int[] printArray (String separator, int[] array){

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1){
                System.out.print(separator);
            }

        }
        return array;

    }

    private static double averageNumber (int[] array){

        double sumOfAllNumbers = 0;
        for (int i = 0; i < array.length; i++) {
            sumOfAllNumbers += array[i];
        }

        return sumOfAllNumbers / array.length;

    }




}
