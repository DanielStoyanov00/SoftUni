package com.company;

import java.util.*;

public class _04ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int numberOfIterations = Integer.parseInt(scanner.nextLine());

        for (String number : result(numberOfIterations, line)) {
            System.out.print(number + " ");
        }

    }

    public static List<String> result(int numberOfIterations, String line) {

        List<String> result = GetList(line);

        for (int i = 0; i < numberOfIterations; i++) {
            String oldValue = result.get(0);
            result.remove(oldValue);
            result.add(oldValue);
        }

        return result;
    }


    public static List<String> GetList(String line) {

        String[] lineAsArray = line.split(" ");

        List<String> result = new ArrayList<>();

        result.addAll(Arrays.asList(lineAsArray));

        return result;
    }
}
