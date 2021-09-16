package _02Constructors;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCars = Integer.parseInt(scanner.nextLine());

        while (numberOfCars-- > 0){
            String[] info = scanner.nextLine().split("\\s+");

            Car car;

            if (info.length == 1){
                car = new Car(info[0]);
            }else if (info.length == 2){
                car = new Car(info[0], info[1]);
            }else {
                car = new Car(info[0], info[1], Integer.parseInt(info[2]));
            }

            System.out.println(car.carInfo());
        }

    }


    }



