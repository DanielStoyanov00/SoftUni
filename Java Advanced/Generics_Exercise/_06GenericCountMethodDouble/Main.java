package _06GenericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            box.add(Double.parseDouble(scanner.nextLine()));
        }

        double doubleToCompare = Double.parseDouble(scanner.nextLine());
        System.out.println(box.count(doubleToCompare));
    }
}
