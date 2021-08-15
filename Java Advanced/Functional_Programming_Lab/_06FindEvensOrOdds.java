package com.company;
import java.util.*;
import java.util.function.Predicate;

public class _06FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbersInRange = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        List<Integer> numbers = new ArrayList<>();
        for (int i = numbersInRange[0]; i <= numbersInRange[1] ; i++) {
            numbers.add(i);
        }

        String evenOrOdd = scanner.nextLine();

        Predicate<Integer> getEvensOrOdds = createPredicate(evenOrOdd);

        numbers.stream()
                .filter(getEvensOrOdds)
                .forEach(number -> {
                    System.out.print(number + " ");
                });
    }

    private static Predicate<Integer> createPredicate(String evenOrOdd) {
        if (evenOrOdd.equals("odd")){
            return n -> n % 2 != 0;
        }
        return n -> n % 2 == 0;
    }
}