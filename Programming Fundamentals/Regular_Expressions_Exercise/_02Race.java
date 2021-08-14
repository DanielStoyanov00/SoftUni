package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class _02Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<String> racers = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        Map<String, Integer> information = new LinkedHashMap<>();

        racers.forEach(racer -> information.put(racer, 0));
        String letterRegex = "[A-Za-z]+";
        String digitsRegex = "[0-9]";

        Pattern letter = Pattern.compile(letterRegex);
        Pattern digit = Pattern.compile(digitsRegex);


        String input = scanner.nextLine();

        while (!input.equals("end of race")) {


            StringBuilder nameBuilder = new StringBuilder();
            Matcher matcherLetter = letter.matcher(input);
            while (matcherLetter.find()) {
                nameBuilder.append(matcherLetter.group());
            }
            String name = nameBuilder.toString();

            int distance = 0;
            Matcher matcherDigit = digit.matcher(input);
            while (matcherDigit.find()) {
                distance += Integer.parseInt(matcherDigit.group());
            }

            if (information.containsKey(name)) {
                information.put(name, information.get(name) + distance);
            }

            input = scanner.nextLine();
        }

        List<String> firstThree = information.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println("1st place: " + firstThree.get(0));
        System.out.println("2nd place: " + firstThree.get(1));
        System.out.println("3rd place: " + firstThree.get(2));


    }
}
