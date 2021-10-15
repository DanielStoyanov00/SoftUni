import java.util.*;
import java.util.stream.Collectors;

public class _07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> namesQueue = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toCollection(ArrayDeque::new));

        int n = Integer.parseInt(scanner.nextLine());
        int cycle = 1;
        while (namesQueue.size() > 1) {

            for (int i = 1; i < n; i++) {
                namesQueue.offer(namesQueue.poll());
            }
            if (isPrime(cycle)) {
                System.out.println("Prime " + namesQueue.peek());
            } else {
                System.out.println("Removed " + namesQueue.poll());
            }

            cycle++;
        }
        String lastName = namesQueue.poll();
        System.out.println("Last is " + lastName);
    }

    private static boolean isPrime(int number) {
        boolean primeCheck = true;
        if (number == 0 || number == 1) {
            return false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    primeCheck = false;
                }
            }
            return primeCheck;
        }
    }
}
