import java.util.Arrays;
import java.util.Scanner;

public class TopNumber10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i <= number; i++) {
           if (oddDigit(i) && divisibleByEight(i)){
               System.out.println(i);
           }
        }


    }

    static boolean oddDigit(int num) {

        int counter = 0;
        while (num > 0) {
            if ((num % 10) % 2 == 1) {
                counter++;
            }
            num /= 10;
        }
        if (counter >= 1) {
            return true;
        } else {
            return false;
        }
    }

    static boolean divisibleByEight(int num) {

        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        if (sum % 8 == 0) {
            return true;
        } else {
            return false;
        }
    }


}




