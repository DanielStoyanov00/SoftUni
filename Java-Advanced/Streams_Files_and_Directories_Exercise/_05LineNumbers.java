package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05LineNumbers {
    public static void main(String[] args) throws IOException {


        Path path = Path.of("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");

        PrintWriter writer = new PrintWriter("output.txt");

        List<String> lines = Files.readAllLines(path);

        int count = 1;

        for (String line : lines){
            writer.println(count + ". " + line);
            count++;
        }
        writer.close();

    }
}
