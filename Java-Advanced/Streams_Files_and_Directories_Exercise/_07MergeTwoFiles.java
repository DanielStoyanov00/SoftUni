package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _07MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path first = Path.of("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path second = Path.of("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");

        List<String> firstPath = Files.readAllLines(first);
        List<String> secondPath = Files.readAllLines(second);

        PrintWriter output = new PrintWriter("output.txt");

       firstPath.forEach(output::println);
       secondPath.forEach(output::println);


    }
}
