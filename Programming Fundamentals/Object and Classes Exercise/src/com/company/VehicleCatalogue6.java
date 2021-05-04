package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleCatalogue6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        ArrayList<Vehicle> cars = new ArrayList<>();
        ArrayList<Vehicle> trucks = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");

            Vehicle vehicle = new Vehicle(tokens[0], tokens[1]
                    , tokens[2], Integer.parseInt(tokens[3]));
            if (vehicle.getType().equals("Truck")) {
                trucks.add(vehicle);
            } else {
                cars.add(vehicle);
            }
            line = scanner.nextLine();
        }

        line = scanner.nextLine();

        while (!line.equals("Close the Catalogue")) {
            String model = line;

            for (Vehicle truck : trucks) {
                if (truck.getModel().equals(model)) {
                    System.out.println(truck.toString());
                }
            }
            for (Vehicle car : cars) {
                if (car.getModel().equals(model)) {
                    System.out.println(car.toString());
                }
            }
            line = scanner.nextLine();
        }
        double truckSum = 0;
        double truckAvg = 0;
        double carSum = 0;
        double carAvg = 0;

        if (!cars.isEmpty()) {
            for (Vehicle car : cars) {
                carSum += car.getHorsePower();
            }
            carAvg = carSum / cars.size();
        }
        System.out.printf("Cars have average horsepower of: %.2f.%n", carAvg);
        if (!trucks.isEmpty()) {
            for (Vehicle truck : trucks) {
                truckSum += truck.getHorsePower();
            }
            truckAvg = truckSum / trucks.size();
        }
        System.out.printf("Trucks have average horsepower of: %.2f.", truckAvg);

    }

    static class Vehicle {
        String type;
        String model;
        String color;
        int horsePower;

        public Vehicle(String type, String model, String color, int horsePower) {
            this.setType(type);
            this.model = model;
            this.color = color;
            this.horsePower = horsePower;
        }

        public String getType() {
            return type;
        }

        private void setType(String type) {
            type = type.replace(type.charAt(0), Character.toUpperCase(type.charAt(0)));
            this.type = type;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public int getHorsePower() {
            return horsePower;
        }

        public void setHorsePower(int horsePower) {
            this.horsePower = horsePower;
        }


        public String toString() {
            return String.format("Type: %s%n" +
                            "Model: %s%n" +
                            "Color: %s%n" +
                            "Horsepower: %d", this.getType(),
                    this.getModel(), this.getColor(), this.getHorsePower());
        }
    }
}



