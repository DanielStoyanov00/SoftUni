package com.company;

import java.io.File;

public class _07ListFiles {
    public static void main(String[] args) {

        File file = new File("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        File[] currentFile = file.listFiles();

        for (File f : currentFile){
            if (!f.isDirectory()){
                System.out.println(f.getName() + ": " + "[" + f.length() + "]");
            }
        }


    }
}
