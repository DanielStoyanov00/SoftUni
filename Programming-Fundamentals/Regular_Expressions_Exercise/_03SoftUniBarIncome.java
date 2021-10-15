package com.company;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _03SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String regex = "^%(?<name>[A-Z][a-z]*)%[^|$%.]*<(?<product>\\w+)>[^|$%.]*\\|(?<count>[0-9]+)\\|[^|$%.]*?(?<price>[0-9]+\\.*[0-9]*)\\$$";
        Pattern pattern = Pattern.compile(regex);


        double totalIncome = 0;

        String input = scanner.nextLine();
        while (!input.equals("end of shift")) {

            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String name = matcher.group("name");
                String product = matcher.group("product");
                int quantity = Integer.parseInt(matcher.group("count"));
                double priceForOne = Double.parseDouble(matcher.group("price"));
                totalIncome += quantity * priceForOne;

                System.out.printf("%s: %s - %.2f\n", name, product, quantity * priceForOne);
            }
            input = scanner.nextLine();
        }


        System.out.printf("Total income: %.2f", totalIncome);


    }
}
