package com.company;

import java.util.Scanner;

public class _05Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("");
            int numberOfDigits = input.length;

            switch (input[0]){
                case "0":
                    System.out.print(" ");
                    break;
                case "2":
                    if (numberOfDigits == 1){
                        System.out.print("a");
                    }else if (numberOfDigits == 2){
                        System.out.print("b");
                    }else {
                        System.out.print("c");
                    }
                    break;
                case "3":
                    if (numberOfDigits == 1){
                        System.out.print("d");
                    }else if (numberOfDigits == 2){
                        System.out.print("e");
                    }else {
                        System.out.print("f");
                    }
                    break;
                case "4":
                    if (numberOfDigits == 1){
                        System.out.print("g");
                    }else if (numberOfDigits == 2){
                        System.out.print("h");
                    }else {
                        System.out.print("i");
                    }
                    break;
                case "5":
                    if (numberOfDigits == 1){
                        System.out.print("j");
                    }else if (numberOfDigits == 2){
                        System.out.print("k");
                    }else {
                        System.out.print("l");
                    }
                    break;
                case "6":
                    if (numberOfDigits == 1){
                        System.out.print("m");
                    }else if (numberOfDigits == 2){
                        System.out.print("n");
                    }else {
                        System.out.print("o");
                    }
                    break;
                case "7":
                    if (numberOfDigits == 1){
                        System.out.print("p");
                    }else if (numberOfDigits == 2){
                        System.out.print("q");
                    }else if (numberOfDigits == 3) {
                        System.out.print("r");
                    }else {
                        System.out.print("s");
                    }
                    break;
                case "8":
                    if (numberOfDigits == 1){
                        System.out.print("t");
                    }else if (numberOfDigits == 2){
                        System.out.print("u");
                    }else {
                        System.out.print("v");
                    }
                    break;
                case "9":
                    if (numberOfDigits == 1){
                        System.out.print("w");
                    }else if (numberOfDigits == 2){
                        System.out.print("x");
                    }else if (numberOfDigits == 3) {
                        System.out.print("y");
                    }else {
                        System.out.print("z");
                    }
                    break;
            }



        }




    }
}
