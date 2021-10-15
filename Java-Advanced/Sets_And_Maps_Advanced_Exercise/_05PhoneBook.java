package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _05PhoneBook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> nameAndPhoneNumber = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")){

            String[] nameAndPhone = input.split("-");
            String name = nameAndPhone[0];
            String phone = nameAndPhone[1];

            nameAndPhoneNumber.put(name,phone);


            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")){

            if (nameAndPhoneNumber.containsKey(input)){
                System.out.printf("%s -> %s\n", input, nameAndPhoneNumber.get(input));

            }else {
                System.out.printf("Contact %s does not exist.\n", input);
            }
            input = scanner.nextLine();
        }
    }
}
