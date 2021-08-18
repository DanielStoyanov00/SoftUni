import java.util.*;

public class _01ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> numbersAsStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbersAsStack::push);

        while (!numbersAsStack.isEmpty()){
            System.out.print(numbersAsStack.pop() + " ");
        }
    }
}
