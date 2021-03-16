import java.util.Scanner;

public class SumEvenNumbers3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String numbersAsString = scanner.nextLine();

        String[] splitNumbers = numbersAsString.split(" ");

        int[] numbers = new int[splitNumbers.length];

        int evenSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(splitNumbers[i]);
        }

        for (int currentNumber : numbers) {
            if (currentNumber % 2 == 0) {
                evenSum += currentNumber;
            }
        }

        System.out.println(evenSum);


    }
}
