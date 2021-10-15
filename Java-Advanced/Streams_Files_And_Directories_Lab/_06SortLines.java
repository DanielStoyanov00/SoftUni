package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _06SortLines {
    public static void main(String[] args) throws IOException {


        Path path = Paths.get("D:\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt");

        List<String> lines = Files.readAllLines(path);
        Collections.sort(lines);

        Files.write(Paths.get("output.txt"), lines);




    }
}
