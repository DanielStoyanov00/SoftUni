package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class _06WordCount {
    public static void main(String[] args) throws IOException {

        // add words that need to be searched into the map
        Path wordsToCheck = Path.of("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\words.txt");

        Map<String, Integer> wordsAndCount = new LinkedHashMap<>();

        List<String> lines = Files.readAllLines(wordsToCheck);

        for (String line : lines){
            String[] words = line.split("\\s+");
            for (String word : words){
                wordsAndCount.put(word, 0);
            }
        }

        // Iterate word by word and check whether map contains key which equals to the word
        Path searched = Path.of("D:\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\text.txt");
        List<String> searchedLines = Files.readAllLines(searched);
        for (String line : searchedLines){
            Arrays.stream(line.split("\\s+"))
                    .forEach(word ->{
                        if (wordsAndCount.containsKey(word)){
                            wordsAndCount.put(word, wordsAndCount.get(word) + 1);
                        }
                    });
        }
        PrintWriter writer = new PrintWriter("output.txt");
        // output
        wordsAndCount.entrySet().stream()
                .forEach(entry -> {
                    writer.printf("%s - %d\n", entry.getKey(), entry.getValue());
                });
        writer.close();









}
    }
