import java.util.Scanner;

public class MultiplicationTable10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        System.out.printf("%d X %d = %d%n", number, 1, number);
        System.out.printf("%d X %d = %d%n", number, 2, number * 2);
        System.out.printf("%d X %d = %d%n", number, 3, number * 3);
        System.out.printf("%d X %d = %d%n", number, 4, number * 4);
        System.out.printf("%d X %d = %d%n", number, 5, number * 5);
        System.out.printf("%d X %d = %d%n", number, 6, number * 6);
        System.out.printf("%d X %d = %d%n", number, 7, number * 7);
        System.out.printf("%d X %d = %d%n", number, 8, number * 8);
        System.out.printf("%d X %d = %d%n", number, 9, number * 9);
        System.out.printf("%d X %d = %d%n", number, 10, number * 10);

    }
}
