package com.company;

import java.util.*;

public class OddOccurrences3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] words = scanner.nextLine().split(" ");

        Map<String, Integer> counts = new LinkedHashMap<>();


        for (String word : words){
            String toLowerCase = word.toLowerCase();
            if (counts.containsKey(toLowerCase)){
                counts.put(toLowerCase, counts.get(toLowerCase) + 1);
            }else {
                counts.put(toLowerCase, 1);
            }
        }

        List<String> odds = new ArrayList<>();

        for (var entry : counts.entrySet()){
            if (entry.getValue() % 2 == 1){
                odds.add(entry.getKey());
            }
        }

        for (int i = 0; i < odds.size(); i++) {
            System.out.print(odds.get(i));
            if (i < odds.size() - 1){
                System.out.print(", ");
            }
        }

    }
}
