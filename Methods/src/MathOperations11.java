import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations11 {


    static double calculateResult(int number1, String operation, double number2) {
        double result = 0.0;

        if (operation.equals("+")) {
            result += number1 + number2;
        } else if (operation.equals("-")) {
            result += number1 - number2;
        } else if (operation.equals("*")) {
            result += number1 * number2;
        } else if (operation.equals("/")) {
            result += number1 / number2;
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number1 = Integer.parseInt(scanner.nextLine());
        String operation = scanner.nextLine();
        int number2 = Integer.parseInt(scanner.nextLine());

        System.out.println(new DecimalFormat("0.###").format(calculateResult(number1, operation, number2)));


    }
}
