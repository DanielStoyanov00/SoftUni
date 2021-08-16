package _05GenericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();

        for (int i = 0; i < n; i++) {
            box.add(scanner.nextLine());
        }

        String stringToCompare = scanner.nextLine();
        int count = box.count(stringToCompare);
        System.out.println(count);


    }
}
