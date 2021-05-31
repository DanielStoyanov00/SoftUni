package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01ValidUsernames {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<String> list = Arrays.stream(input.split(", "))
                .collect(Collectors.toList());

        List<String> validPass = new ArrayList<>();

        for (String pass : list) {
            if (pass.length() >= 3 && pass.length() <= 16) {
                validPass.add(pass);
            }
            if (pass.contains("@") || pass.contains("&") || pass.contains("!") || pass.contains("#") ||
                    pass.contains("$") || pass.contains("%") || pass.contains(" ")) {
                validPass.remove(pass);
            }
        }

        for (String valPass : validPass) {
            System.out.println(valPass);
        }


    }
}
