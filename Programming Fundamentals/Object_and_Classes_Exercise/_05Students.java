package com.company;

import java.util.*;

public class Students5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        List<StudentInformation> studentInfo = new ArrayList<>();


        for (int i = 0; i < N; i++) {
            String[] line = scanner.nextLine().split(" ");
            StudentInformation current = new StudentInformation(line[0], line[1], Double.parseDouble(line[2]));

            studentInfo.add(current);

        }

        studentInfo.sort(Comparator.comparing(StudentInformation::getGrade));
        Collections.reverse(studentInfo);

        for (StudentInformation current : studentInfo) {
            System.out.printf("%s %s: %.2f%n", current.firstName, current.lastName, current.grade);
        }


    }


    static class StudentInformation {
        String firstName;
        String lastName;
        double grade;


        public StudentInformation(String firstName, String lastName, double grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.grade = grade;
        }


        public double getGrade() {
            return grade;
        }
    }
}
