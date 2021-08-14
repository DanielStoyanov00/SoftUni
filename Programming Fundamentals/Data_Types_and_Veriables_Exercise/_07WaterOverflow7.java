import java.util.Scanner;

public class WaterOverflow7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int sum = 0;
        int quantity = 255;

        for (int i = 1; i <= number; i++) {
            int currentQuantity = Integer.parseInt(scanner.nextLine());

            if (currentQuantity > quantity) {
                System.out.println("Insufficient capacity!");
            } else {
                quantity -= currentQuantity;
                sum += currentQuantity;
            }


        }
        System.out.printf("%d", sum);


    }
}
