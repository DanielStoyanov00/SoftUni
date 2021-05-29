import java.util.Scanner;

public class PrintPartOfASCIITable5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNumber = Integer.parseInt(scanner.nextLine());
        int lastNumber = Integer.parseInt(scanner.nextLine());

        for (int i = startNumber; i <= lastNumber ; i++) {
            System.out.print((char) i + " ");

        }
    }
}
