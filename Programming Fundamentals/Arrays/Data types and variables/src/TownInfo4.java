import java.util.Scanner;

public class TownInfo4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String townName = scanner.nextLine();
        int population = Integer.parseInt(scanner.nextLine());
        double kilometers = Double.parseDouble(scanner.nextLine());


        System.out.printf("Town %s has population of %d and area %.0f square km.", townName, population, kilometers);
    }
}
