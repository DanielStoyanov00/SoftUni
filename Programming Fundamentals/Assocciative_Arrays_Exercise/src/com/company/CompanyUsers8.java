package com.company;

import java.util.*;

public class CompanyUsers8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, List<String>> information = new TreeMap<>();

        String input = scanner.nextLine();

        while(!input.equals("End")){
            String[] array = input.split(" -> ");
            String company = array[0];
            String id = array[1];

            if (!information.containsKey(company)){
                information.put(company, new ArrayList<>());
                information.get(company).add(id);
            }else {
                if (information.get(company).contains(id)){
                  information.get(company).remove(company);
                }else {
                    information.get(company).add(id);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, List<String>> entry : information.entrySet()) {
            System.out.println(entry.getKey());
            for (String id : entry.getValue()){
                System.out.println("-- " + id);
            }
        }


    }
}
