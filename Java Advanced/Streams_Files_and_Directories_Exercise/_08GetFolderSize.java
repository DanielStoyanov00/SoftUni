package com.company;

import java.io.*;

public class _08GetFolderSize {
    public static void main(String[] args) throws IOException {

        String path ="D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        File folder = new File(path);

        long sum = 0;
        for (File file : folder.listFiles()){
            sum += file.length();
        }
        System.out.println("Folder size: " + sum);
    }
}
