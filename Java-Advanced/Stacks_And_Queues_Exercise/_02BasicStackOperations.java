import java.util.*;

public class _02BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> numbersInStack = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(numbersInStack::push);

        for (int i = 0; i < numbers[1]; i++) {
            numbersInStack.pop();
        }

        if (!numbersInStack.isEmpty()){
            if (numbersInStack.contains(numbers[2])){
                System.out.println("true");
            }else {
                System.out.println(Collections.min(numbersInStack));
            }
        }else {
            System.out.println(0);
        }
    }
}
