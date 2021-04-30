package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("end")) {
            String[] studentParameters = line.split(" ");
            Student currentStudent = new Student(studentParameters[0], studentParameters[1],
                    Integer.parseInt(studentParameters[2]), studentParameters[3]);


            int existingIndex = findStudentIndex(students, currentStudent.getFirstName(), currentStudent.getLastName());

            if (existingIndex != -1) {
                students.get(existingIndex).setHomeTown(currentStudent.homeTown);
                students.get(existingIndex).setAge(currentStudent.age);
            } else {
                students.add(currentStudent);
            }


            line = scanner.nextLine();
        }


        String townName = scanner.nextLine();

        for (Student student : students) {
            if (student.getHomeTown().equals(townName)) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(), student.getAge());


            }
        }

    }

    static int findStudentIndex(List<Student> students, String firstName, String lastName) {

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getFirstName().equals(firstName) && students.get(i).getLastName().equals(lastName)) {
                return i;

            }
        }
        return -1;
    }


    static class Student {
        String firstName;
        String lastName;
        int age;
        String homeTown;


        public Student(String firstName, String lastName, int age, String homeTown) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.homeTown = homeTown;
        }

        public String getFirstName() {

            return firstName;
        }

        public String getLastName() {

            return lastName;
        }

        public int getAge() {

            return age;
        }

        public String getHomeTown() {

            return homeTown;
        }

        public void setAge(int age) {

            this.age = age;
        }

        public void setHomeTown(String homeTown) {

            this.homeTown = homeTown;
        }
    }
}
