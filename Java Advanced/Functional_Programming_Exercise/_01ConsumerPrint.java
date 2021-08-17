import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _01ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Consumer<List<String>> printNames = name -> names.forEach(System.out::println);
        printNames.accept(names);
    }
}
