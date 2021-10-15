package com.company;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCompounds = Integer.parseInt(scanner.nextLine());

        Set<String> chemicalCompounds = new TreeSet<>();

        for (int i = 0; i < numberOfCompounds; i++) {
            String[] currentLineOfCompounds = scanner.nextLine().split("\\s+");

            for (String currentCompound : currentLineOfCompounds) {
                if (!chemicalCompounds.contains(currentCompound)) {
                    chemicalCompounds.add(currentCompound);
                }
            }
        }
        chemicalCompounds.forEach(compound -> System.out.print(compound + " "));
    }
}
