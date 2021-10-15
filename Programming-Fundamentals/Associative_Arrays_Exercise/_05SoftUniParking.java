package com.company;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniParking5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        Map<String, String> registeredPeople = new LinkedHashMap<>();

        for (int i = 0; i < numberOfCommands; i++) {
            String[] command = scanner.nextLine().split(" ");

            if (command.length == 3) {
                if (!registeredPeople.containsKey(command[1])) {
                    registeredPeople.put(command[1], command[2]);
                    System.out.println(command[1] + " " + "registered" + " " + command[2] + " " + "successfully");
                } else {
                    System.out.println("ERROR: already registered with plate number" + " " + registeredPeople.get(command[1]));
                }
            } else {
                if (!registeredPeople.containsKey(command[1])) {
                    System.out.println("ERROR: user " + command[1] + " " + "not found");
                } else {
                    System.out.println(command[1] + " " + "unregistered successfully");
                    registeredPeople.remove(command[1]);
                }
            }

        }

        registeredPeople.entrySet().stream()
                .forEach(e -> System.out.println(e.getKey() + " => " + e.getValue()));


    }
}
