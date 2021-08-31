package com.company;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class _04ExtractIntegers {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new FileInputStream("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt"));

        PrintWriter output = new PrintWriter("output.txt");

        while (scanner.hasNext()){
            if (scanner.hasNextInt()){
                output.println(scanner.nextInt());
            }
            scanner.next();
        }
        output.close();
    }
}
