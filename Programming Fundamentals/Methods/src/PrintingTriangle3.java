import java.util.Scanner;

public class PrintingTriangle3 {

    static void printNumbers(int lastNumber) {
        for (int i = 1; i <= lastNumber; i++) {
            System.out.print(i);
            if (i < lastNumber){
                System.out.print(" ");
            }
        }
        System.out.println();

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxLengthLine = scanner.nextInt();

        for (int i = 1; i <= maxLengthLine; i++) {
            printNumbers(i);

        }

        for (int i = maxLengthLine - 1; i >= 1; i--) {
            printNumbers(i);
        }


    }


}
