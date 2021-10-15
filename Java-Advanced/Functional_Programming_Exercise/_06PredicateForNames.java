import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wordLength = Integer.parseInt(scanner.nextLine());
        List<String> words = Arrays.asList(scanner.nextLine().split("\\s+"));

        Predicate<String> filterWordsBiggestOrEqual = word -> word.length() <= wordLength;

        words.stream()
                .filter(filterWordsBiggestOrEqual)
                .forEach(System.out::println);
    }
}
