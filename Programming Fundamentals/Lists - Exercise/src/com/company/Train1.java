package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOfWagons = scanner.nextLine();
        int maxNumberOfPeopleInWagon = Integer.parseInt(scanner.nextLine());

        List<Integer> list = parseLineOfWagons(lineOfWagons);


        while (true){
            String line = scanner.nextLine();

            if (line.equals("end")){
                break;
            }

            String[] lineAsArray = line.split(" ");

            if (lineAsArray[0].equals("Add")){
                int number = Integer.parseInt(lineAsArray[1]);
                list.add(number);
            }else {
                int number = Integer.parseInt(lineAsArray[0]);
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i) + number <= maxNumberOfPeopleInWagon){
                        list.set(i, number + list.get(i));
                        break;
                    }
                }
            }
        }
        for (int number : list){
            System.out.print(number + " ");
        }

    }


    public static List<Integer> parseLineOfWagons (String lineOfWagons){

        String[] array = lineOfWagons.split(" ");

        ArrayList<Integer> list = new ArrayList<>();

        for (String s : array){
            int number = Integer.parseInt(s);
            list.add(number);
        }
        return list;
    }
}
