package com.company;

import java.util.Scanner;

public class _01Ages {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int input = scanner.nextInt();

        if (input >= 0 && input <= 2){
            System.out.println("baby");
        }else if (input >= 3 && input <= 13){
            System.out.println("child");
        }else if (input >= 14 && input <= 19){
            System.out.println("teenager");
        }else if (input >= 20 && input <= 65){
            System.out.println("adult");
        }else {
            System.out.println("elder");
        }

    }
}
