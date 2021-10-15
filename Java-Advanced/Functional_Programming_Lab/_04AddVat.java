import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class _04AddVat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Function<Double, Double> addedVat = e -> e * 1.20;
        String[] numbersAsString = scanner.nextLine().split(", ");
        System.out.println("Prices with VAT:");
        Arrays.stream(numbersAsString)
                .mapToDouble(Double::parseDouble)
                .boxed()
                .map(addedVat)
                .forEach(num -> {
                    System.out.printf("%.2f\n", num);
                });
    }
}
