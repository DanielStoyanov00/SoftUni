import java.util.Scanner;

public class BeerKegs8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfKegs = Integer.parseInt(scanner.nextLine());

        double biggestNumber = 0;
        String theBiggestKeg = "";


        for (int i = 1; i <= numberOfKegs ; i++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double currentKeg = Math.PI * radius * radius * height;

            if (currentKeg > biggestNumber){
                biggestNumber = currentKeg;
                theBiggestKeg = model;
            }



        }
        System.out.printf("%s",theBiggestKeg );
    }
}
