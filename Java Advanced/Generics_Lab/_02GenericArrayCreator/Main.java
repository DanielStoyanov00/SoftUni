package _02GenericArrayCreator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] integers = ArrayCreator.create(Integer.class, 10, 10);
        String[] names = ArrayCreator.create(String.class, 10, "empty");

        for (Integer integer : integers) {
            System.out.println(integer);
        }

        for (String name : names) {
            System.out.println(name);
        }
    }
}

