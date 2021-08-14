package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "([@|#])(?<firstWord>[A-Za-z]{3,})\\1\\1(?<secondWord>[A-Za-z]{3,})\\1";
        int counter = 0;


        List<String> words = new ArrayList<>();
        List<String> mirrorWords = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String firstWord = matcher.group("firstWord");
            String secondWord = matcher.group("secondWord");
            counter++;

            StringBuilder sb = new StringBuilder();
            String mirrorWord = sb.append(secondWord).reverse().toString();

            if (firstWord.equals(mirrorWord)){
                words.add(firstWord);
                mirrorWords.add(secondWord);
            }

        }
        if (counter == 0){
            System.out.println("No word pairs found!");

        }else {
            System.out.printf("%d word pairs found!\n", counter);
        }

        if (words.isEmpty()){
            System.out.println("No mirror words!");
        }else {
            System.out.println("The mirror words are:");
            for (int i = 0; i < words.size(); i++) {
               if (i == words.size() - 1){
                   System.out.print(words.get(i) + " <=> " + mirrorWords.get(i));
               } else {
                   System.out.print(words.get(i) + " <=> " + mirrorWords.get(i) + ", ");
               }
            }
        }


    }
}
