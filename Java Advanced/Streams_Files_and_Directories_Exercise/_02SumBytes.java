package com.company;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class _02SumBytes {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new FileReader(
                "D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt"));

        PrintWriter output = new PrintWriter("output.txt");


        String line = reader.readLine();
        long sum = 0;
        while (line != null){
            sum += line.chars().sum();

            line = reader.readLine();
        }
        output.println(sum);
        output.close();

    }
}
