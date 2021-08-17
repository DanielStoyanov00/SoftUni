import java.util.*;

public class _03DecimalToBinaryConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> binaryDigit = new ArrayDeque<>();
        int number = scanner.nextInt();

        if (number == 0){
            System.out.println(0);
            return;
        }

        while (number != 0){
            binaryDigit.push(number % 2);
            number /= 2;
        }
        binaryDigit.forEach(System.out::print);

    }
}
