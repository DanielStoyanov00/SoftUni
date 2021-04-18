package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveNegativesAndReverse7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> lineOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());


        lineOfNumbers.removeIf(n -> n < 0);
        Collections.reverse(lineOfNumbers);

        if (lineOfNumbers.isEmpty()){
            System.out.println("empty");
        }else {
            for(int number : lineOfNumbers){
                System.out.print(number + " ");
            }
        }
        }

    }

