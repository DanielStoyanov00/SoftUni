import java.util.Scanner;

public class SumOfChars4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

            int sum = 0;
        for (int i = 1; i <= number ; i++) {
            char letter = scanner.nextLine().charAt(0);
            sum += letter;

        }
        System.out.printf("The sum equals: %d", sum);
    }
}
