package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _02ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        List<Integer> list = getList(array);

        if (list.isEmpty()) {
            return;
        }

        String input = scanner.nextLine();
        while (!input.equals("end")) {
            String[] splitted = input.split(" ");

            if (splitted[0].equals("Delete")) {
                int number = Integer.parseInt(splitted[1]);
                for (int i = list.size() - 1; i >= 0; i--) {
                    if (list.get(i) == number) {
                        list.remove(i);
                    }
                }

            } else if (splitted[0].equals("Insert")) {
                int number = Integer.parseInt(splitted[1]);
                int index = Integer.parseInt(splitted[2]);

                list.add(index, number);


            }
            input = scanner.nextLine();
        }

        for (int num : list) {
            System.out.print(num + " ");
        }
    }


    public static List<Integer> getList(String[] array) {

        List<Integer> list = new ArrayList<>();

        for (String num : array) {
            int number = Integer.parseInt(num);
            list.add(number);
        }

        return list;


    }
}
