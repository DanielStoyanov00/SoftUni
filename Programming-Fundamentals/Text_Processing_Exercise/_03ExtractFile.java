package com.company;

import java.util.Scanner;

public class _03ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        String[] array = line.split("\\\\");
        String file = array[array.length - 1];

        String fileName = file.substring(0, file.lastIndexOf('.'));
        String fileExtension = file.substring(file.lastIndexOf('.') + 1);

        System.out.printf("File name: %s\nFile extension: %s", fileName, fileExtension);
    }
}
