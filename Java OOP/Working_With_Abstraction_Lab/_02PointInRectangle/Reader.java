package _02PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static Scanner scanner = new Scanner(System.in);


    public static int[] readIntegerArray(String delimiter){
        return Arrays.stream(scanner.nextLine().split(delimiter))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
