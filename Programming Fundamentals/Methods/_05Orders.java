import java.util.Scanner;

public class Orders5 {


    static void calculateCoffee(int quantity, double coffeePrice) {
        double sum = quantity * coffeePrice;
        System.out.printf("%.2f", sum);
    }

    static void calculateWater(int quantity, double waterPrice) {
        double sum = quantity * waterPrice;
        System.out.printf("%.2f", sum);
    }

    static void calculateCoke(int quantity, double cokePrice) {
        double sum = quantity * cokePrice;
        System.out.printf("%.2f", sum);
    }

    static void calculateSnacks(int quantity, double snacksPrice) {
        double sum = quantity * snacksPrice;
        System.out.printf("%.2f", sum);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double coffeePrice = 1.5;
        double waterPrice = 1.0;
        double cokePrice = 1.4;
        double snacksPrice = 2.0;

        if (product.equals("coffee")) {
            calculateCoffee(quantity, coffeePrice);
        } else if (product.equals("water")) {
            calculateWater(quantity, waterPrice);
        } else if (product.equals("coke")) {
            calculateCoke(quantity, cokePrice);
        } else if (product.equals("snacks")) {
            calculateSnacks(quantity, snacksPrice);
        }


    }
}
