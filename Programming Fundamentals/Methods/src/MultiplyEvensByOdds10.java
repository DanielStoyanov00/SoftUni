import java.util.Scanner;

public class MultiplyEvensByOdds10 {

    static int getMultiplyEvenAndOddsSum(int number) {
        int finalResult = getEvenSum(number) * getOddSum(number);

        return finalResult;

    }

    static int getEvenSum(int number) {
        int evenSum = 0;
        while (number != 0) {
            int nextNumber = number % 10;


            if (nextNumber % 2 == 0) {
                evenSum += nextNumber;
            }
            number /= 10;
        }
        return evenSum;
    }


    static int getOddSum(int number) {
        int oddSum = 0;
        while (number != 0) {
            int nextNumber = number % 10;


            if (nextNumber % 2 == 1) {
                oddSum += nextNumber;
            }
            number /= 10;
        }
        return oddSum;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        int result = getMultiplyEvenAndOddsSum(number);
        System.out.println(result);


    }


}

