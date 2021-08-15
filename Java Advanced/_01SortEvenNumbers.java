import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> numbersAsString = Arrays.stream(scanner.nextLine().split(", "))
                .collect(Collectors.toList());

        String result = numbersAsString.stream()
                .mapToInt(Integer::parseInt)
                .filter(e -> e % 2 == 0)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(result);

        String reversedResult = Arrays.stream(result.split(", "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));

        System.out.println(reversedResult);
    }
}
