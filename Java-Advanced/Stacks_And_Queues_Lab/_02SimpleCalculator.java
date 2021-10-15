import java.util.*;

public class _02SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbers = new ArrayDeque<>();

        String[] input = scanner.nextLine().split("\\s+");

        for (int i = 0; i < input.length; i++) {
            String token = input[i];
            if (Character.isDigit((token.charAt(0)))) {
                numbers.push(Integer.parseInt(token));
            } else {
                int rightDigit = Integer.parseInt(input[++i]);
                int leftDigit = numbers.peek();
                numbers.push(rightDigit);

                int result = token.equals("+")
                        ? leftDigit + rightDigit
                        : leftDigit - rightDigit;
                numbers.push(result);
            }

        }
        System.out.println(numbers.peek());
    }
}
