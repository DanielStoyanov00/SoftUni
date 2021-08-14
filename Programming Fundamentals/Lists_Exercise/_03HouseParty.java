package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _03HouseParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();


        for (int i = 0; i < numberOfCommands; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (input.length == 3){
                if (names.contains(input[0])){
                    System.out.printf("%s is already in the list!\n", input[0]);
                }else {
                    names.add(input[0]);
                }
            }else {
                if (names.contains(input[0])){
                    names.remove(input[0]);
                }else {
                    System.out.printf("%s is not in the list!\n", input[0]);
                }
            }

        }

        for (String name: names){
            System.out.println(name);
        }


    }
}



