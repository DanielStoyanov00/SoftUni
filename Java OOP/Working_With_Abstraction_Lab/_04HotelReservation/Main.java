package _04HotelReservation;

public class Main {
    public static void main(String[] args) {
        String[] tokens = Reader.readStringArray("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = Discount.parseDiscount(tokens[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay,days,season,discount);

        System.out.printf("%.2f\n", priceCalculator.calculatePrice());

    }


}
