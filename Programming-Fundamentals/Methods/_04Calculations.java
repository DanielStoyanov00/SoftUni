import java.util.Scanner;


public class Calculations4 {
    static int add(int first, int second) {

        return first + second;
    }

    static int subtract(int first, int second) {

        return first - second;
    }

    static int divide(int first, int second) {

        return first / second;
    }

    static int multiply(int first, int second) {

        return first * second;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String action = scanner.nextLine();
        int first = Integer.parseInt(scanner.nextLine());
        int second = Integer.parseInt(scanner.nextLine());


        if (action.equals("add")) {
            System.out.println(add(first, second));
        } else if (action.equals("subtract")) {
            System.out.println(subtract(first, second));
        } else if (action.equals("divide")) {
            System.out.println(divide(first, second));
        } else if (action.equals("multiply")) {
            System.out.println(multiply(first, second));
        }
    }
}
