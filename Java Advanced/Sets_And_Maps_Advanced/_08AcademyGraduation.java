package com.company;

import java.util.*;

public class _08AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, double[]> students = new TreeMap<>();

        int studentsToRead = Integer.parseInt(scanner.nextLine());

        while (studentsToRead-- > 0) {
            String studentName = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToDouble(Double::parseDouble)
                    .toArray();
            students.put(studentName, scores);
        }

        for (String key : students.keySet()) {
            System.out.printf("%s is graduated with %s\n", key, getAvg(students.get(key)));
        }
    }

    private static double getAvg(double[] scores) {
        double average = 0;

        for (double score : scores) {
            average += score;
        }

        average /= scores.length;
        return average;
    }





    }





