package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _05BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        List<Integer> list = SequenceOfNumbers(input);

        String[] bombInfo = scanner.nextLine().split(" ");
        int bombNumber = Integer.parseInt(bombInfo[0]);
        int power = Integer.parseInt(bombInfo[1]);

        while (list.contains(bombNumber)) {
            int index = list.indexOf(bombNumber);

            int leftBound = Math.max(0, index - power);
            int rightBound = Math.min(list.size() - 1, index + power);

            for (int i = rightBound; i >= leftBound; i--) {
                list.remove(i);
            }
        }

        int sum = 0;
        for (int num : list) {
            sum += num;
        }
        System.out.println(sum);

    }

    static List<Integer> SequenceOfNumbers(String input) {

        String[] array = input.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String num : array) {
            int number = Integer.parseInt(num);
            list.add(number);
        }

        return list;
    }


}
