import java.util.Scanner;

public class SpiceMustFlow9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        int amountOfSpices = 0;
        int counterInDays = 0;

        while (startingYield >= 100) {

            amountOfSpices += startingYield - 26;
            counterInDays++;
            startingYield -= 10;

            if (startingYield < 100) {
                amountOfSpices -= 26;
                break;
            }
        }

        System.out.printf("%d%n", counterInDays);
        System.out.printf("%d", amountOfSpices);

    }
}
