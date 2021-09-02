package _04HotelReservation;

import java.util.Scanner;

public class Reader {
    public static Scanner scanner = new Scanner(System.in);

    public static String[] readStringArray(String delimiter){
        return scanner.nextLine().split(delimiter);
    }
}
