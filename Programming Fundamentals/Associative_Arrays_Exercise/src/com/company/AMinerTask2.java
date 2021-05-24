package com.company;

import java.util.*;

public class AMinerTask2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> result = new LinkedHashMap<>();

        String line = scanner.nextLine();

        while (!line.equals("stop")){
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!result.containsKey(line)){
                result.put(line, quantity);
            }else {
                Integer replace = result.get(line) + quantity;
                result.replace(line,replace);
            }



            line = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }


    }
}
