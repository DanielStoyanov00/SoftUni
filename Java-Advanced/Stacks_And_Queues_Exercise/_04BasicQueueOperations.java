import java.util.*;

public class _04BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int S = numbers[1];
        int X = numbers[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .forEach(queue::offer);

        for (int i = 0; i < S; i++) {
            queue.poll();
        }

        if (queue.isEmpty()){
            System.out.println(0);
            return;
        }

        if (queue.contains(X)){
            System.out.println("true");
        }else {
            System.out.println(Collections.min(queue));
        }

    }
}
