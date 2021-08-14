package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Match ALL of these
        //13/Jul/1928
        //10-Nov-1934
        //25.Dec.1937
        //Match NONE of these
        //01/Jan-1951
        //23/sept/1973
        //1/Feb/2016
        String regex = "\\b(?<day>\\d{2})([-.\\/])(?<month>[A-Z][a-z]{2})\\2(?<year>[\\d]{4}\\b)";
        String line = scanner.nextLine();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(line);

        List<String> list = new ArrayList<>();

        while (matcher.find()){
            String day = matcher.group("day");
            String month = matcher.group("month");
            String year = matcher.group("year");

            System.out.printf("Day: %s, Month: %s, Year: %s\n",day,month,year);

        }





    }
}
