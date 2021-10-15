package com.company;

import java.util.Scanner;

public class _07AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] arrays = scanner.nextLine().split("\\|");

        String result = "";
        for (int i = arrays.length - 1; i >= 0 ; i--) {
            String[] currentArray = arrays[i].split("\\s+");
            for (int j = 0; j < currentArray.length; j++) {
                if(!currentArray[j].equals("")){
                    result += currentArray[j] + " ";
                }

            }

        }

        System.out.println(result.trim());


    }
}
