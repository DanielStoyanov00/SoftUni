package _03StudentSystem;

import java.util.Scanner;

public class Reader {
    public static Scanner scanner = new Scanner(System.in);

    public static String[] readArray(String delimiter){
        return scanner.nextLine().split(delimiter);
    }
}
