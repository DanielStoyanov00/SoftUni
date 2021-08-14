import java.util.Scanner;


public class Grades2 {
    static void printGrade(double rate) {
        if (rate >= 2.00 && rate <= 2.99) {
            System.out.println("Fail");
        } else if (rate >= 3.00 && rate <= 3.49) {
            System.out.println("Poor");
        } else if (rate >= 3.50 && rate <= 4.49) {
            System.out.println("Good");
        } else if (rate >= 4.50 && rate <= 5.49) {
            System.out.println("Very good");
        } else {
            System.out.println("Excellent");
        }


    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        printGrade(Double.parseDouble(scanner.nextLine()));
    }


}
