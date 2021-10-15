package com.company;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01UniqueUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Set<String> usernames = new LinkedHashSet<>();

        int numberOfUsers = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfUsers; i++) {
            String user = scanner.nextLine();

            if (!usernames.contains(user)){
                usernames.add(user);
            }

        }

        usernames.forEach(System.out::println);


    }
}
