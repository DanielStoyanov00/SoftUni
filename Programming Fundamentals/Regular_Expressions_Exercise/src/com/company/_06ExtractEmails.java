package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _06ExtractEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = "\\b(([a-zA-Z0-9]+)([.\\-_]?)([a-zA-z0-9]+))(@)([a-zA-Z]+.[a-zA-Z]+[.?[a-zA-Z]+]*)\\b";

        Pattern pattern = Pattern.compile(regex);


        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()){
            System.out.println(matcher.group());
        }









    }
}
