package com.company;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01SumLines {

    public static void main(String[] args) throws IOException {

        Path path = Path.of("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");

        PrintWriter output = new PrintWriter("output.txt");

        List<String> lines = Files.readAllLines(path);

        for (String line : lines){
            int sum = 0;

            for (int i = 0; i < line.length(); i++) {
                sum += line.charAt(i);
            }
            output.println(sum);

        }
        output.close();


    }
}
