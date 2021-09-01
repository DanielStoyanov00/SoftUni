package _02Collection;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1)
                .collect(Collectors.toList());

        Collection collection = new Collection(data);
        String command;
        while (!"END".equals(command = scanner.nextLine())){
            switch (command){
                case "Move":
                    System.out.println(collection.move());
                    break;
                case "Print":
                    collection.print();
                    break;
                case "HasNext":
                    System.out.println(collection.hasNext());
                    break;
                case "PrintAll":
                    collection.printAll();
                    break;
            }
        }
    }
}
