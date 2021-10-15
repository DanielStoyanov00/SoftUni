package _01GenericBox;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());
        Box<String> box = new Box<>();
        for (int i = 0; i < numberOfCommands; i++) {
            String element = scanner.nextLine();
            box.add(element);
        }
        System.out.print(box);

    }
}
