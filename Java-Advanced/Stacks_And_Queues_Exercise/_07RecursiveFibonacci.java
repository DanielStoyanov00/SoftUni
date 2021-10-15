import java.util.Scanner;

public class _07RecursiveFibonacci {
    public static long[] memoryForFibonacci;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());
        memoryForFibonacci = new long[number + 1];

        System.out.println(fibonacci(number));

    }

    public static long fibonacci (int number){

        if (number <= 1){
            return 1;
        }
        if (memoryForFibonacci[number] != 0){
            return memoryForFibonacci[number];
        }

        return memoryForFibonacci[number] = fibonacci(number - 1) + fibonacci(number - 2);

    }
}
