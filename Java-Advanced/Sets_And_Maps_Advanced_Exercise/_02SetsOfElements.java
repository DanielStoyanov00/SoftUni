package com.company;

import java.util.*;

public class _02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] lengthOfTwoSets = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        List<Integer> first = new ArrayList<>();
        List<Integer> second = new ArrayList<>();

        for (int i = 0; i < lengthOfTwoSets[0] + lengthOfTwoSets[1]; i++) {
            int number = Integer.parseInt(scanner.nextLine());

            if (i < lengthOfTwoSets[0]){
                first.add(number);
            }else {
                second.add(number);
            }
        }

        Set<Integer> matchingNumbers = new LinkedHashSet<>();

        for (int currentNumberFromFirstList : first) {
            for (int currentNumberFromSecondList : second) {
                if (currentNumberFromFirstList == currentNumberFromSecondList) {
                    matchingNumbers.add(currentNumberFromFirstList);
                   break;
                }
            }
        }
        matchingNumbers.forEach(number -> System.out.print(number + " "));
    }
}
