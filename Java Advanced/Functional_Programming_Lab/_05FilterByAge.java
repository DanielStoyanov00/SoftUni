package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class _05FilterByAge {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] personInfo = scanner.nextLine().split(", ");
            people.add(new Person(personInfo[0], Integer.parseInt(personInfo[1])));
        }

        String criteria = scanner.nextLine();
        int ageCriteria = Integer.parseInt(scanner.nextLine());

        Predicate<Person> ageFilter = createAgeFilter(criteria, ageCriteria);

        String format = scanner.nextLine();
        Function<Person, String> formatter = createFormatter(format);

        people.stream()
                .filter(ageFilter)
                .map(formatter)
                .forEach(System.out::println);
    }

    private static Function<Person, String> createFormatter(String format) {
        if (format.equals("name")) {
            return person -> person.name;
        } else if (format.equals("age")) {
            return person -> String.valueOf(person.age);
        } else {
            return person -> String.format("%s - %d", person.name, person.age);
        }

    }

    private static Predicate<Person> createAgeFilter(String criteria, int ageCriteria) {
        if (criteria.equals("older")) {
            return person -> person.age >= ageCriteria;
        }
        return person -> person.age <= ageCriteria;

    }

    public static class Person {
        String name;
        int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
}