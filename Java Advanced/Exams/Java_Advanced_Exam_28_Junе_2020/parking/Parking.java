package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.capacity > this.data.size()) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (Car car : this.data) {
            if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        if (data.isEmpty()) {
            return null;
        } else {
            List<Car> sorted = data.stream().sorted((a, b) -> Integer.compare(b.getYear(), a.getYear())).collect(Collectors.toList());
            return sorted.get(0);
        }
    }

    public Car getCar(String manufacturer, String model) {
        if (!this.data.isEmpty()) {
            for (Car car : this.data) {
                if (car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)) {
                    return car;
                }
            }
        }
        return null;
    }


    public int getCount(){
        return this.data.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type));
        sb.append(System.lineSeparator());
        for (Car car : this.data){
            sb.append(car);
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

}
