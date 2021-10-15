package _04Froggy;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stonesNumbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Lake lake = new Lake(stonesNumbers);

        int index = 0;
        for (Integer integer : lake) {
            index++;
            if (index == stonesNumbers.length) {
                System.out.print(integer);
            } else {
                System.out.print(integer + ", ");
            }
        }
    }
}
