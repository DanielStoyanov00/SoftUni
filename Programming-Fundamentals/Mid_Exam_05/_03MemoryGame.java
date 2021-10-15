package com.company;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03MemoryGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> sequence = Arrays.stream(scanner.nextLine().split(" " ))
                .collect(Collectors.toList());

        int moves = 0;
        String line = scanner.nextLine();
        while (!line.equals("end" )) {

            moves++;
            String[] indexes = line.split(" " );
            int firstIndex = Integer.parseInt(indexes[0]);
            int secondIndex = Integer.parseInt(indexes[1]);


            if (firstIndex == secondIndex || firstIndex < 0 || firstIndex >= sequence.size()
                    || secondIndex < 0 || secondIndex >= sequence.size()) {

                int middleIndex = sequence.size() / 2;

                sequence.add(middleIndex, "-" + moves + "a" );
                sequence.add(middleIndex, "-" + moves + "a" );
                System.out.println("Invalid input! Adding additional elements to the board" );
            } else if (sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                String indexValue = sequence.get(firstIndex);
                if (firstIndex > secondIndex) {
                    sequence.remove(firstIndex);
                    sequence.remove(secondIndex);
                } else {
                    sequence.remove(secondIndex);
                    sequence.remove(firstIndex);
                }
                System.out.printf("Congrats! You have found matching elements - %s!\n", indexValue);
            } else if (!sequence.get(firstIndex).equals(sequence.get(secondIndex))) {
                System.out.println("Try again!" );
            }
            if (sequence.isEmpty()) {
                System.out.printf("You have won in %d turns!", moves);
                return;
            }


            line = scanner.nextLine();
        }

        System.out.println("Sorry you lose :(" );
        System.out.print(String.join(" ", sequence));


    }
}
