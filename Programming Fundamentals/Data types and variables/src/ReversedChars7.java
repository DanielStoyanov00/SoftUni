import java.util.Scanner;

public class ReversedChars7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String first = scanner.nextLine();
        String second = scanner.nextLine();
        String third = scanner.nextLine();

        System.out.printf("%s %s %s", third, second, first);
    }
}
