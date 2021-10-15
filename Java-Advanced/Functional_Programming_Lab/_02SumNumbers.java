import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _02SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        Function<String, Integer> parser = Integer::parseInt;

        int sum = Arrays.stream(input)
                .mapToInt(Integer::parseInt)
                .sum();

        System.out.printf("Count = %d\n", input.length);
        System.out.printf("Sum = %d", sum);
    }
}
