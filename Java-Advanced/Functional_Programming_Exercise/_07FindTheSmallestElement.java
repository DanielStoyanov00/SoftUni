import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _07FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));

        Function<List<Integer>, Integer> indexOfSmallestNumber = list -> {
            int minNumber = Collections.min(list);
            return list.lastIndexOf(minNumber);
        };

        System.out.println(indexOfSmallestNumber.apply(numbers));
    }
}
