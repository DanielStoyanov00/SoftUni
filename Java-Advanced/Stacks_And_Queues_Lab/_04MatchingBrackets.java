import java.util.*;

public class _04MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> expression = new ArrayDeque<>();

        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);
            if (symbol == '(') {
                expression.push(i);
            } else if (symbol == ')') {
                String substring = input.substring(expression.pop(), i + 1);
                System.out.println(substring);
            }
        }
    }
}
