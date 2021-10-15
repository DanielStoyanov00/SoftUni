package com.company;

import java.util.*;

public class _09UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();

        TreeMap<String, LinkedHashMap<String, Integer>> result = new TreeMap<>();

        fillingTheMap(scanner, info, result);
        printResult(result);

    }

    private static void printResult(TreeMap<String, LinkedHashMap<String, Integer>> result) {
        for (Map.Entry<String, LinkedHashMap<String, Integer>> user : result.entrySet()) {
            List<String> ipRow = new ArrayList<>();
            System.out.printf("%s:\n", user.getKey());

            for (Map.Entry<String, Integer> entry : user.getValue().entrySet()) {
                ipRow.add(entry.getKey() + " => " + entry.getValue());
            }
            System.out.print(String.join(", ", ipRow));
            if (ipRow.size() > 0) {
                System.out.println(".");
            }
        }
    }

    private static void fillingTheMap(Scanner scanner, String info, TreeMap<String, LinkedHashMap<String, Integer>> result) {
        while (!info.equals("end")) {
            String[] input = info.split(" ");
            String ip = input[0].split("=")[1];
            String user = input[2].split("=")[1];

            if (!result.containsKey(user)) {
                result.put(user, new LinkedHashMap<>());
            }
            if (!result.get(user).containsKey(ip)) {
                result.get(user).put(ip, 0);
            }
            result.get(user).put(ip, result.get(user).get(ip) + 1);

            info = scanner.nextLine();
        }
    }
}
