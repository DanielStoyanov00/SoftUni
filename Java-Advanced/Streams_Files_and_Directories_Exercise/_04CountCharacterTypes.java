package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class _04CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        PrintWriter output = new PrintWriter("output.txt");

        String vowels = "aeiou";
        String punctuation = ",.!?";

        int vowelsCount = 0;
        int consonantCount = 0;
        int punctuationCount = 0;

        String line = reader.readLine();
        while (line != null) {

            for (int i = 0; i < line.length(); i++) {

                if (line.charAt(i) == ' ') {
                    continue;
                }
                if (vowels.contains(String.valueOf(line.charAt(i)))) {
                    vowelsCount++;
                } else if (punctuation.contains(String.valueOf(line.charAt(i)))) {
                    punctuationCount++;
                } else {
                    consonantCount++;
                }
            }

            line = reader.readLine();
        }
        output.println("Vowels: " + vowelsCount);
        output.println("Consonants: " + consonantCount);
        output.println("Punctuation: " + punctuationCount);
        output.close();
    }
}
