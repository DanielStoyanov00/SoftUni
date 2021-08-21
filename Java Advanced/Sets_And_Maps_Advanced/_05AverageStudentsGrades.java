package com.company;

import java.util.*;

public class _05AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> students = new TreeMap<>();
        int counter = Integer.parseInt(scanner.nextLine());
        while (counter-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String student = tokens[0];
            double grade = Double.parseDouble(tokens[1]);

            students.putIfAbsent(student, new ArrayList<>());
            students.get(student).add(grade);
        }

        students.entrySet()
                .stream()
                .forEach(entry -> {
                    double sum = 0;
                    for (int i = 0; i < entry.getValue().size(); i++) {
                        sum += entry.getValue().get(i);
                    }
                    double avgSum = sum / entry.getValue().size();

                    System.out.print(entry.getKey() + " -> ");
                    entry.getValue().forEach(e -> System.out.printf("%.2f ", e));
                    System.out.printf("(avg: %.2f)\n", avgSum);
                });
    }
}
