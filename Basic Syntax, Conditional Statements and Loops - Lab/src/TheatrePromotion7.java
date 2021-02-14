import java.util.Scanner;

public class TheatrePromotion7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());

        int ticketPrice = 0;
        boolean itsTrue = false;

        switch (day) {
            case "Weekday":
                if (age >= 0 && age <= 18) {
                    ticketPrice = 12;
                } else if (age > 18 && age <= 64) {
                    ticketPrice = 18;
                } else if (age > 64 && age <= 122) {
                    ticketPrice = 12;
                } else {
                    itsTrue = true;
                    break;
                }
                break;
            case "Weekend":
                if (age >= 0 && age <= 18) {
                    ticketPrice = 15;
                } else if (age > 18 && age <= 64) {
                    ticketPrice = 20;
                } else if (age > 64 && age <= 122) {
                    ticketPrice = 15;
                } else {
                    itsTrue = true;
                    break;
                }
                break;
            case "Holiday":
                if (age >= 0 && age <= 18) {
                    ticketPrice = 5;
                } else if (age > 18 && age <= 64) {
                    ticketPrice = 12;
                } else if (age > 64 && age <= 122) {
                    ticketPrice = 10;
                } else {
                    itsTrue = true;
                    break;
                }
                break;

        }
        if (itsTrue) {
            System.out.println("Error!");
        } else {
            System.out.printf("%d$", ticketPrice);

        }

    }
}
