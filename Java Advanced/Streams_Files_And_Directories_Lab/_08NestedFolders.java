package com.company;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

public class _08NestedFolders {
    public static void main(String[] args) {

        File file = new File("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");

        Deque<File> deque = new ArrayDeque<>();
        deque.add(file);

        int counter = 0;
        while (!deque.isEmpty()){
            // 1. poll file
            // 2. increase counter and print file name
            // 3. take the files from current directory
            // 4. check whether inner file is directory
            // 4.1 if it's directory add it into the deque

            File f = deque.poll();
            counter++;
            System.out.println(f.getName());

            File[] files = f.listFiles();

            for (File innerFile : files){
                if (innerFile.isDirectory()){
                    deque.offer(innerFile);
                }
            }

        }
        System.out.printf("%d folders", counter);
    }
}
