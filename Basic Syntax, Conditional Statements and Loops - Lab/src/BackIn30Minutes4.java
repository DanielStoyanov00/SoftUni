import java.util.Scanner;

public class BackIn30Minutes4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = minutes + 30;

        if (totalMinutes > 59) {
            totalMinutes -= 60;
            hours += 1;
        }
        if (hours > 23) {
            hours = 0;
        }
        if (totalMinutes < 10) {
            System.out.printf("%d:0%d", hours, totalMinutes);
        } else {
            System.out.printf("%d:%d", hours, totalMinutes);

        }

    }
}
