import java.util.*;
import java.util.Collections;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Collections.reverse(numbers);

        int divider = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> isDivisible = num -> num % divider != 0;

        numbers.stream()
                .filter(isDivisible)
                .forEach(n -> System.out.print(n + " "));
    }
}
