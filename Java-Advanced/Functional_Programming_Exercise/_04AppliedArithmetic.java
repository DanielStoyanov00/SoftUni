import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;

public class _04AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            switch (command) {
                case "add":
                    Function<int[], int[]> increment = arr -> Arrays.stream(arr).map(e -> e += 1).toArray();
                    numbers = increment.apply(numbers);
                    break;
                case "subtract":
                    Function<int[], int[]> subtract = arr -> Arrays.stream(arr).map(e -> e -= 1).toArray();
                    numbers = subtract.apply(numbers);
                    break;
                case "multiply":
                    Function<int[], int[]> multiplier = arr -> Arrays.stream(arr).map(e -> e *= 2).toArray();
                    numbers = multiplier.apply(numbers);
                    break;
                case "print":
                    Consumer<int[]> printNumbers = arr -> Arrays.stream(arr).forEach(e -> System.out.print(e + " "));
                    printNumbers.accept(numbers);
                    System.out.println();
                    break;
            }


            command = scanner.nextLine();
        }
    }
}
