package com.company;

import java.util.Scanner;

public class _03Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        double numberOfPeople = Double.parseDouble(scanner.nextLine());
        String person = scanner.nextLine();
        String day = scanner.nextLine();

        double totalPrice = 0;

        switch (person) {
            case "Students":
                switch (day) {
                    case "Friday":
                        if (numberOfPeople >= 30) {
                            totalPrice = numberOfPeople * 8.45 * 0.85;
                        } else {
                            totalPrice = numberOfPeople * 8.45;
                        }
                        break;
                    case "Saturday":
                        if (numberOfPeople >= 30) {
                            totalPrice = numberOfPeople * 9.80 * 0.85;
                        } else {
                            totalPrice = numberOfPeople * 9.80;
                        }
                        break;
                    case "Sunday":
                        if (numberOfPeople >= 30) {
                            totalPrice = numberOfPeople * 10.46 * 0.85;
                        } else {
                            totalPrice = numberOfPeople * 10.46;
                        }
                        break;
                }
                break;
            case "Business":
                switch (day) {
                    case "Friday":
                        if (numberOfPeople >= 100) {
                            numberOfPeople = numberOfPeople - 10;
                            totalPrice = numberOfPeople * 10.90;
                        } else {
                            totalPrice = numberOfPeople * 10.90;
                        }
                        break;
                    case "Saturday":
                        if (numberOfPeople >= 100) {
                            numberOfPeople = numberOfPeople - 10;
                            totalPrice = numberOfPeople * 15.60;
                        } else {
                            totalPrice = numberOfPeople * 15.60;
                        }
                        break;
                    case "Sunday":
                        if (numberOfPeople >= 100) {
                            numberOfPeople = numberOfPeople - 10;
                            totalPrice = numberOfPeople * 16;
                        } else {
                            totalPrice = numberOfPeople * 16;
                        }
                        break;
                }
                break;
            case "Regular":
                switch (day) {
                    case "Friday":
                        totalPrice = numberOfPeople * 15;
                        break;
                    case "Saturday":
                        totalPrice = numberOfPeople * 20;
                        break;
                    case "Sunday":
                        totalPrice = numberOfPeople * 22.50;
                        break;
                }
                if (numberOfPeople >= 10 && numberOfPeople <= 20) {
                    totalPrice = totalPrice * 0.95;
                }
                break;


        }

        System.out.printf("Total price: %.2f", totalPrice);
    }
}
