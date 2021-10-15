import java.util.*;

public class _01BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stackUrl = new ArrayDeque<>();
        ArrayDeque<String> forwardStack = new ArrayDeque<>();

        String input;
        while (!"Home".equals(input = scanner.nextLine())) {

            if ("back".equals(input)) {
                if (stackUrl.size() > 1) {
                    String toRemove = stackUrl.pop();
                    forwardStack.push(toRemove);
                    System.out.println(stackUrl.peek());
                } else {
                    System.out.println("no previous URLs");
                }
                continue;
            }
            if ("forward".equals(input)) {
                if (forwardStack.size() > 0) {
                    String something = forwardStack.pop();
                    System.out.println(something);
                    stackUrl.push(something);
                } else {
                    System.out.println("no next URLs");
                }
                continue;
            }
            System.out.println(input);
            stackUrl.push(input);
            forwardStack.clear();
        }
    }
}
