package com.company;

import java.io.*;

public class _03AllCapitals {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        PrintWriter output = new PrintWriter("output.txt");

        String line = reader.readLine();

        while (line != null){

            output.println(line.toUpperCase());

            line = reader.readLine();
        }
        output.close();
    }
}
