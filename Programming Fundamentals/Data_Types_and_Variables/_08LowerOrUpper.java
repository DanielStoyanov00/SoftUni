import java.util.Scanner;

public class LowerOrUpper8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String letter = scanner.nextLine();

        if (letter.charAt(0) >= 65 && letter.charAt(0) <= 95){
            System.out.println("upper-case");
        }else {
            System.out.println("lower-case");
        }

    }
}
