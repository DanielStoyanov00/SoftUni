package com.company;

import java.util.Scanner;

public class _04ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        StringBuilder reversed = new StringBuilder();

        reversed.append(line);
        reversed.reverse();

        System.out.println(reversed);
    }
}
