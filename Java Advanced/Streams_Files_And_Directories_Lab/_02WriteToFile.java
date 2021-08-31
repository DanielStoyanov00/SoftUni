package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _02WriteToFile {
    public static void main(String[] args) throws IOException {

        String inputPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath = "D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\output.txt";

        InputStream input = new FileInputStream(inputPath);
        OutputStream output = new FileOutputStream(outputPath);

        List<Character> punctuation = new ArrayList<>();
        Collections.addAll(punctuation, ',', '.', '!', '?');


        int oneByte = 0;
        while((oneByte = input.read()) >= 0){
            if (!punctuation.contains((char)oneByte)){
                output.write(oneByte);
            }
        }
        output.close();







    }
}
