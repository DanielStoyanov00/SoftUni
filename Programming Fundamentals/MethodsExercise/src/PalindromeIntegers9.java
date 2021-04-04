import java.util.Scanner;

public class PalindromeIntegers9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.nextLine();

        while (!number.equals("END")) {

            System.out.println(reversed(number));

            number = scanner.nextLine();
        }


    }

    static String reversed(String number) {

        String reversed = "";

        for (int i = number.length() - 1; i >= 0; i--) {
            reversed += (number.charAt(i));
        }

        if (reversed.equals(number)) {
            reversed = "true";
        } else {
            reversed = "false";
        }

        return reversed;


    }
}










