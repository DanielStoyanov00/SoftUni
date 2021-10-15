import java.util.ArrayDeque;
import java.util.Scanner;

public class _06BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> deque = new ArrayDeque<>();
        String[] input = scanner.nextLine().split("");

        boolean isMatch = true;
        for (String parentheses : input) {
            switch (parentheses) {
                case "(":
                    deque.push(")");
                    break;
                case "[":
                    deque.push("]");
                    break;
                case "{":
                    deque.push("}");
                    break;
                case ")":
                case "]":
                case "}":
                    if (deque.isEmpty() || !deque.pop().equals(parentheses)) {
                        isMatch = false;
                    }
                    break;
            }
        }
        System.out.println(isMatch ? "YES" : "NO");
    }
}
