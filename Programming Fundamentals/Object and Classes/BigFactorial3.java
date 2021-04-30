package com.company;

import java.math.BigInteger;
import java.util.Scanner;

public class BigFactorial3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = Integer.parseInt(scanner.nextLine());

        System.out.println(factorial(number));

    }

    public static BigInteger factorial (int number){
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }
        return factorial;

    }
}
