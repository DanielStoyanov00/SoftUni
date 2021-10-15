package com.company;

import java.io.*;

public class _05WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(
                new FileReader("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));

        PrintWriter output = new PrintWriter(new FileWriter("output.txt"));

        int counter = 1;
        String line = reader.readLine(); // single line of text
        while (line != null){
            if (counter % 3 == 0){
                output.println(line);
            }
            counter++;
            line = reader.readLine();
        }
        output.close();


    }
}
