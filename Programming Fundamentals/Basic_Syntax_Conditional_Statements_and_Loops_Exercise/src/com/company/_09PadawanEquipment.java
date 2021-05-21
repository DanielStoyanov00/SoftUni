package com.company;

import java.util.Scanner;

public class _09PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double amountOfMoney = Double.parseDouble(scanner.nextLine());
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        double singlePriceForLightSabers = Double.parseDouble(scanner.nextLine());
        double singlePriceForRobes = Double.parseDouble(scanner.nextLine());
        double singlePriceForBelts = Double.parseDouble(scanner.nextLine());

        double numberOfLightSabers = Math.ceil(numberOfStudents + numberOfStudents * 0.10);
        double totalPrice = numberOfLightSabers * singlePriceForLightSabers
                + numberOfStudents * singlePriceForRobes
                + numberOfStudents * singlePriceForBelts;

        int counter = 0;
        for (int i = 0; i < numberOfStudents; i++) {
            counter ++;
            if (counter % 6 == 0){
                totalPrice -= singlePriceForBelts;
            }
        }

        if (amountOfMoney >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        }else {
            System.out.printf("George Lucas will need %.2flv more.", totalPrice - amountOfMoney);
        }


    }
}
