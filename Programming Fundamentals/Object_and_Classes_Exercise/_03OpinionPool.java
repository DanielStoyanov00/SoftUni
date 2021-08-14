package com.company;

import java.util.*;

public class OpinionPool3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<Person> person = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(" ");

            Person parameters = new Person(line[0], Integer.parseInt(line[1]));

            parameters.name = line[0];
            parameters.years = Integer.parseInt(line[1]);

            if (parameters.years > 30) {
                person.add(parameters);
            }

        }

        person.sort(Comparator.comparing(Person::getName));

        for (Person current : person) {
            System.out.println(current.name + " " + "-" + " " + current.years);
        }


    }


    static class Person {
        String name;
        int years;


        public Person(String name, int years) {
            this.name = name;
            this.years = years;

        }


        public String getName() {
            return name;
        }


    }
}
