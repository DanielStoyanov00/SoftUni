package com.company;

import java.util.*;

public class _03NeedForSpeed3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Map<String, Integer> modelAndMileage = new LinkedHashMap<>();
        Map<String, Integer> modelAndFuel = new LinkedHashMap<>();

        int number = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < number; i++) {
            String[] tokens = scanner.nextLine().split("\\|");

            modelAndMileage.put(tokens[0], Integer.parseInt(tokens[1]));
            modelAndFuel.put(tokens[0], Integer.parseInt(tokens[2]));
        }


        String command = scanner.nextLine();
        while (!command.equals("Stop")) {
            String[] commands = command.split(" : ");
            String action = commands[0];
            String carModel = commands[1];
            switch (action) {
                case "Drive":
                    int distance = Integer.parseInt(commands[2]);
                    int fuel = Integer.parseInt(commands[3]);
                    if (modelAndFuel.get(carModel) >= fuel) {
                        modelAndFuel.put(carModel, modelAndFuel.get(carModel) - fuel);
                        System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.\n", carModel, distance, fuel);
                        modelAndMileage.put(carModel, modelAndMileage.get(carModel) + distance);
                        if (modelAndMileage.get(carModel) > 100000) {
                            modelAndFuel.remove(carModel);
                            modelAndMileage.remove(carModel);
                            System.out.printf("Time to sell the %s!\n", carModel);
                            break;
                        }
                    } else {
                        System.out.println("Not enough fuel to make that ride");
                    }
                    break;
                case "Refuel":
                    int fuelToRefuel = Integer.parseInt(commands[2]);
                    if (modelAndFuel.get(carModel) + fuelToRefuel <= 75) {
                        modelAndFuel.put(carModel, modelAndFuel.get(carModel) + fuelToRefuel);
                        System.out.printf("%s refueled with %d liters\n", carModel, fuelToRefuel);
                    } else {
                        int refuel = Math.abs((modelAndFuel.get(carModel) + fuelToRefuel) - (fuelToRefuel + 75));
                        modelAndFuel.put(carModel, modelAndFuel.get(carModel) + refuel);
                        System.out.printf("%s refueled with %d liters\n", carModel, refuel);
                    }
                    break;
                case "Revert":
                    int kilometersToDecrease = Integer.parseInt(commands[2]);

                        if (modelAndMileage.get(carModel) - kilometersToDecrease > 10000) {
                            modelAndMileage.put(carModel, modelAndMileage.get(carModel) - kilometersToDecrease);
                            System.out.printf("%s mileage decreased by %d kilometers\n", carModel, kilometersToDecrease);
                        } else {
                            modelAndMileage.replace(carModel, 10000);
                        }

                    break;
                default:
                    break;
            }


            command = scanner.nextLine();
        }

        modelAndMileage
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String,Integer>comparingByValue()
                        .reversed()
                        .thenComparing(Map.Entry.comparingByKey()))
                .forEach(n -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.\n", n.getKey(), n.getValue(), modelAndFuel.get(n.getKey()));
                });


    }


}
