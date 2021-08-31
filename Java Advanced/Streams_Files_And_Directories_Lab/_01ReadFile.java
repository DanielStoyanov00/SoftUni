package com.company;

import java.io.FileInputStream;
import java.io.IOException;

public class _01ReadFile {

    public static void main(String[] args) throws IOException {

        String path = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        FileInputStream fileStream = new FileInputStream(path);

        int oneByte = fileStream.read();

        while (oneByte >= 0) {

            System.out.print(Integer.toBinaryString(oneByte) + " ");

            oneByte = fileStream.read();

        }

    }
}
