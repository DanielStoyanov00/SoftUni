package _01ListIterator;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> data = Arrays.stream(scanner.nextLine().split("\\s+")).skip(1)
                .collect(Collectors.toList());

        ListyIterator listyIterator = new ListyIterator(data);
        String command;
        while (!"END".equals(command = scanner.nextLine())){
            switch (command){
                case "Move":
                    System.out.println(listyIterator.move());
                    break;
                case "Print":
                    listyIterator.print();
                    break;
                case "HasNext":
                    System.out.println(listyIterator.hasNext());
                    break;
            }
        }
    }
}
