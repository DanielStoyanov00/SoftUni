package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _02DestinationMapper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String regex = "(=|/)(?<destination>[A-Z][A-Za-z]{2,})\\1";
        int travelPoints = 0;

        List<String> destinations = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);


        while (matcher.find()){
            destinations.add(matcher.group("destination"));
            travelPoints += matcher.group("destination").length();
        }

        if (destinations.isEmpty()){
            System.out.println("Destinations: ");
        }else {
            System.out.print("Destinations: ");
            int counter = 0;
            for (String destination : destinations) {
                counter ++;

                if (counter == destinations.size()){
                    System.out.println(destination);
                }else {
                    System.out.print(destination + ", ");
                }
            }
        }

        System.out.printf("Travel Points: %d", travelPoints);

    }
}
