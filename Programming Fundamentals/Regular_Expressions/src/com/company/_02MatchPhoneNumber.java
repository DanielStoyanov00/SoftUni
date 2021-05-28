package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Match ALL of these
        //+359 2 222 2222
        //+359-2-222-2222

        //Match NONE of these
        //359-2-222-2222, +359/2/222/2222, +359-2 222 2222
        //+359 2-222-2222, +359-2-222-222, +359-2-222-22222

        String line = scanner.nextLine();
        String regex = "\\+359([ -])2\\1\\d{3}\\1\\d{4}\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        List<String> list = new ArrayList<>();

        while (matcher.find()){
          list.add(matcher.group());
        }
        System.out.print(String.join(", ", list));


    }
}
