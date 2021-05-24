package com.company;

import java.util.Scanner;

public class _01Train {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfWagons = Integer.parseInt(scanner.nextLine());
        int sum = 0;

        for (int i = 1; i <= numberOfWagons; i++) {
            int countOfPeople = Integer.parseInt(scanner.nextLine());
            sum += countOfPeople;

            System.out.print(countOfPeople);

            if (i != numberOfWagons){
                System.out.print(" ");
            }else {
                System.out.println();
            }


        }
        System.out.print(sum);



    }
}
