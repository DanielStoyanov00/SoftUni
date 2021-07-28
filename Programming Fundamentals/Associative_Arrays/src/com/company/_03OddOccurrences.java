package com.company;

import java.util.*;
import java.util.stream.Collectors;

public class _03OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> info = new LinkedHashMap<>();

        List<String> words = Arrays.stream(scanner.nextLine()
                .toLowerCase()
                .split("\\s+"))
                .collect(Collectors.toList());

        words.forEach(word -> {
                   info.compute(word, (key,value) ->
                           (value == null) ? 1 : info.get(word) + 1);
                });

        List<String> odd = new ArrayList<>();

        info.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 != 0)
                .forEach(e -> {
                    odd.add(e.getKey());
                });

        for (int i = 0; i < odd.size(); i++) {
            if (i < odd.size() - 1){
                System.out.print(odd.get(i) + ", ");
            }else {
                System.out.print(odd.get(i));
            }
        }



    }
}
