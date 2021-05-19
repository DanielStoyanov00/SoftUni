package com.company;

import java.util.Scanner;

public class Substring3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String wordToRemove = scanner.nextLine();
        String line = scanner.nextLine();

        while (line.contains(wordToRemove)){
            line = removeOccurrence(line,wordToRemove);
        }

        System.out.println(line);

    }

    private static String removeOccurrence(String line, String wordToRemove) {

        int beginIndex = line.indexOf(wordToRemove);
        int endIndex = beginIndex + wordToRemove.length();

        return line.substring(0,beginIndex) + line.substring(endIndex);



    }
}
