package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _04StarEnigma {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int count = Integer.parseInt(scanner.nextLine());
        List<String> attacked = new ArrayList<>();
        List<String> destroyed = new ArrayList<>();


        for (int i = 0; i < count; i++) {
            String encryptedMessage = scanner.nextLine();
            int counterSpecialLetter = getSpecialNumbers(encryptedMessage);
            String decryptedMessage = getDecryptedMessage(encryptedMessage, counterSpecialLetter);


            String regex = "@(?<planetName>[a-zA-Z]+)[^@!:>\\-]*:(?<population>[0-9]+)[^@!:>\\-]*!(?<attack>[AD])![^@!:>\\-]*->(?<soldiers>\\d+)";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(decryptedMessage);
            if (matcher.find()) {
                String planet = matcher.group("planetName");
                String attack = matcher.group("attack");

                if (attack.equals("A")){
                    attacked.add(planet);
                }else if (attack.equals("D")){
                    destroyed.add(planet);
                }
            }


        }

        printOutput(attacked,destroyed);


    }

    private static void printOutput(List<String> attacked, List<String> destroyed) {
        Collections.sort(attacked);
        Collections.sort(destroyed);

        System.out.println("Attacked planets: " + attacked.size());
        if (!attacked.isEmpty()){
            attacked.forEach(p -> System.out.println("-> " + p));
        }
        System.out.println("Destroyed planets: " + destroyed.size());
        if (!destroyed.isEmpty()){
            destroyed.forEach(d -> System.out.println("-> " + d));
        }

    }

    private static String getDecryptedMessage(String encryptedMessage, int counterSpecialLetter) {
        StringBuilder reduceMessage = new StringBuilder();
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char currentSymbol = encryptedMessage.charAt(i);
            reduceMessage.append((char)(currentSymbol - counterSpecialLetter));
        }
        return reduceMessage.toString();
    }

    static int getSpecialNumbers(String encryptedMessage) {
        int count = 0;
        String regexLetter = "[SsTtAaRr]";
        Pattern pattern = Pattern.compile(regexLetter);
        Matcher matcher = pattern.matcher(encryptedMessage);

        while (matcher.find()) {
            count++;
        }

        return count;

    }


}
