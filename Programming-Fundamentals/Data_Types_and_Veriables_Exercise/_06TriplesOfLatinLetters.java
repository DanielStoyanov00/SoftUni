import java.util.Scanner;

public class TriplesOfLatinLetters6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < number ; i++) {
            for (int j = 0; j < number ; j++) {
                for (int k = 0; k < number ; k++) {
                    System.out.printf("%c%c%c%n", (char) ('a' + i), (char) ('a' + j), (char) ('a' + k));


                }
            }
        }

    }
}
