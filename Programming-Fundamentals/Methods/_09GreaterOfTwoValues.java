import java.util.Locale;
import java.util.Scanner;

public class GreaterOfTwoValues9 {


    static String getString(String first, String second) {
        if (first.compareTo(second) >= 0) {
            return first;
        }
        return second;
    }

    static int getInt(int first, int second) {
        if (first > second) {
            return first;
        }
        return second;
    }

    static char getChar(String firstChar, String secondChar) {
        char first = firstChar.charAt(0);
        char second = secondChar.charAt(0);
        if (first > second) {
            return first;
        }
        return second;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String function = scanner.nextLine();

        if (function.equals("int")) {
            int first = Integer.parseInt(scanner.nextLine());
            int second = Integer.parseInt(scanner.nextLine());
            System.out.println(getInt(first, second));
        } else if (function.equals("string")) {
            String first = scanner.nextLine();
            String second = scanner.nextLine();
            System.out.println(getString(first, second));
        } else if (function.equals("char")) {
            String firstChar = scanner.nextLine();
            String secondChar = scanner.nextLine();
            System.out.println(getChar(firstChar, secondChar));

        }


    }
}
