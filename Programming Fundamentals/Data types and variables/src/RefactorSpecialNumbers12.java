import java.util.Scanner;

public class RefactorSpecialNumbers12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int sumOfDigits = 0;
            int digits = i;
            while (digits > 0) {
                sumOfDigits += digits % 10;
                digits = digits / 10;
            }

            if (sumOfDigits == 5 || sumOfDigits == 7 || sumOfDigits == 11) {
                System.out.printf("%d -> True%n", i);
            } else {
                System.out.printf("%d -> False%n", i);
            }

        }
    }
}

