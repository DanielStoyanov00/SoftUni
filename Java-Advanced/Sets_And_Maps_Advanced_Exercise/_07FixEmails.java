package com.company;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> nameAndEmail = new LinkedHashMap<>();

        String name = scanner.nextLine();
        while (!name.equals("stop")){
            String fullEmail = scanner.nextLine();
            String[] splitEmail = fullEmail.split("\\.");
            String domain = splitEmail[1];

            if (domain.equals("bg")){
                nameAndEmail.put(name, fullEmail);
            }
            name = scanner.nextLine();
        }
        nameAndEmail.entrySet()
                .stream()
                .forEach(entry -> System.out.printf("%s -> %s\n", entry.getKey(), entry.getValue()));

    }
}
