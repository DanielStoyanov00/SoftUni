package com.company;

import java.util.Scanner;

public class IntegerOperations1 {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);

        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());
        int third = Integer.parseInt(scanner.nextLine());
        int fourth = Integer.parseInt(scanner.nextLine());


        int add = first + second;
        int divide = add / third;
        int result = divide * fourth;

        System.out.println(result);
    }
}
