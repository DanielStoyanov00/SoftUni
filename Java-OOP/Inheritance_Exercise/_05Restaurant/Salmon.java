package Restaurant;

import java.math.BigDecimal;

public class Salmon extends MainDish{
    private static double SALMON_GRAMS = 22;

    public Salmon(String name, BigDecimal price, double SALMON_GRAMS){
        super(name,price,SALMON_GRAMS);
    }

    @Override
    public void setGrams(double grams) {
        super.setGrams(SALMON_GRAMS);
    }
}
