package _02Constructors;

public class Car {
    private String brand;
    private String model;
    private int horsePower;


    public Car(String brand) {
        this.brand = brand;
        this.model = "unknown";
        this.horsePower = -1;
    }

    public Car(String brand, String model) {
        this(brand);
        this.model = model;
    }

    public Car(String brand, String model, int horsePower) {
        this(brand, model);
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    public String carInfo(){
        return this.toString();
    }

    @Override
    public String toString(){
        return String.format("The car is: %s %s - %d HP.",
                this.getBrand(),
                this.getModel() != null ? this.getModel() : "unknown",
                this.getHorsePower() != 0 ? this.getHorsePower() : -1);
    }


}

