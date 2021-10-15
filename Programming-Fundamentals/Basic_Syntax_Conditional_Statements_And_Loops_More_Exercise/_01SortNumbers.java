package com.company;

import java.util.*;

public class _01SortNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());

        List<Integer> numbers = new ArrayList<>();
        numbers.add(firstNumber);
        numbers.add(secondNumber);
        numbers.add(thirdNumber);

        Collections.sort(numbers);
        Collections.reverse(numbers);

        numbers.forEach(System.out::println);

    }
}
