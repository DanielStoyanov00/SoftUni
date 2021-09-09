package _02CarShopExtended;

public class Main {
    public static void main(String[] args) {

        Sellable seat = new Seat("Leon", "Gray", 110, "Spain", 11111.1);
        Rentable audi = new Audi("A4", "Gray", 110, "Germany", 3, 99.9);

        System.out.println(seat);
        System.out.println(audi);
    }
}
