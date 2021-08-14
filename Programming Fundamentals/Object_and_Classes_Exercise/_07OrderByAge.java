package com.company;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class OrderByAge7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<PersonInfo> personInformation = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {

            if (line.equals("End")) {
                break;
            }
            String[] tokens = line.split(" ");

            PersonInfo personInfo = new PersonInfo(tokens[0], tokens[1], Integer.parseInt(tokens[2]));

            personInformation.add(personInfo);


            line = scanner.nextLine();
        }

        personInformation.sort(Comparator.comparing(PersonInfo::getYears));

        for (PersonInfo currentPerson : personInformation) {
            System.out.printf("%s with ID: %s is %d years old.%n", currentPerson.name, currentPerson.ID, currentPerson.years);
        }

    }


    static class PersonInfo {
        String name;
        String ID;
        int years;


        public PersonInfo(String name, String ID, int years) {
            this.name = name;
            this.ID = ID;
            this.years = years;
        }

        public String getName() {
            return name;
        }

        public String getID() {
            return ID;
        }

        public int getYears() {
            return years;
        }
    }
}
