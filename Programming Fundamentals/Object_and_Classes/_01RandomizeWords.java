package com.company;

import java.util.Random;
import java.util.Scanner;

public class RandomizeWords1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        String[] words = line.split(" ");

        Random random = new Random();

        for (int i = 0; i < words.length; i++) {
            int a = random.nextInt(words.length);
            int b = random.nextInt(words.length);

            String oldWord = words[a];
            words[a] = words[b];
            words[b] = oldWord;

        }

        System.out.println(String.join(System.lineSeparator(), words));

    }
}
