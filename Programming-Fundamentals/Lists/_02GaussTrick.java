package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> list = parseLineOfNumbers(scanner);

        List<Integer> output = new ArrayList<>();

        boolean itsOdd = false;
        int middleNumber = 0;

        if (list.size() % 2 == 1) {
            middleNumber = list.get(list.size() / 2);
            itsOdd = true;
        }


        for (int i = 0; i < list.size() - 1; i++) {
            int first = list.get(i);
            int last = list.get(list.size() - 1);

            list.remove(list.size() - 1);
            output.add(first + last);


        }

        for (int number : output) {
            System.out.print(number + " ");
        }
        if (itsOdd) {
            System.out.print(middleNumber);
        }


    }


    public static List<Integer> parseLineOfNumbers(Scanner scanner) {
        String line = scanner.nextLine();

        String[] lineAsArray = line.split(" ");

        ArrayList<Integer> lineAsList = new ArrayList<>();

        for (String s : lineAsArray) {
            int number = Integer.parseInt(s);
            lineAsList.add(number);
        }
        return lineAsList;
    }


}
