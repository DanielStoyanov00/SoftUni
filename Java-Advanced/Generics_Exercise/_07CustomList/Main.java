package _07CustomList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        CustomList<String> list = new CustomList<>();

        while (!input.equals("END")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "Add":
                    String elementToAdd = tokens[1];
                    list.add(elementToAdd);
                    break;
                case "Remove":
                    int indexToRemove = Integer.parseInt(tokens[1]);
                    list.remove(indexToRemove);
                    break;
                case "Contains":
                    String elementToCheck = tokens[1];
                    System.out.println(list.contains(elementToCheck));
                    break;
                case "Swap":
                    int firstIndex = Integer.parseInt(tokens[1]);
                    int secondIndex = Integer.parseInt(tokens[2]);
                    list.swap(firstIndex,secondIndex);
                    break;
                case "Greater":
                    String elementToCompare = tokens[1];
                    System.out.println(list.countGreaterThan(elementToCompare));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    System.out.print(list);
                    break;
                default:
                    break;

            }
            input = scanner.nextLine();
        }
    }
}
