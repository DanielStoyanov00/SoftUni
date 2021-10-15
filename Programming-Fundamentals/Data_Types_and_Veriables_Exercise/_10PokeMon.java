import java.util.Scanner;

public class PokeMon10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        double equalsToN = power * 0.50;

        while (power >= distance) {
            power -= distance;
            counter++;

            if (power == equalsToN && Y != 0) {
                power /= Y;
            }

        }
        System.out.println(power);
        System.out.println(counter);


    }
}
