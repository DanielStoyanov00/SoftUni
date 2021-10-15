package _04NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        SportCar raceMotorcycle = new SportCar(10, 200);
        raceMotorcycle.drive(1);

        System.out.println(raceMotorcycle.getFuel());
        System.out.println(raceMotorcycle.getFuelConsumption());
        System.out.println(raceMotorcycle.getHorsePower());


        double expectedFuel = 0;
        double expectedFuelConsumption = 10;
        int expectedHorsePower = 200;

    }
}
