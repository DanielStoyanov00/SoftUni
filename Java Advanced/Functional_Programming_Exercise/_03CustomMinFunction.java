import java.util.*;
import java.util.function.Function;

public class _03CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> smallestNumber = number -> Arrays.stream(number).min().getAsInt();

        System.out.println(smallestNumber.apply(numbers));
    }
}
