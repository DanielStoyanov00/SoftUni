import java.util.Scanner;

public class RepeatString7 {

    static void newString(String line, int countNumber) {

        for (int i = 0; i < countNumber; i++) {
            System.out.print(line);
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        int countNumber = Integer.parseInt(scanner.nextLine());

        newString(line, countNumber);
    }
}
