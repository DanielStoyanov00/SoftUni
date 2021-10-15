package _05ComparingObjects;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> people = new ArrayList<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] personInfo = input.split("\\s+");

            Person person = new Person(personInfo[0],Integer.parseInt(personInfo[1]),personInfo[2]);
            people.add(person);

            input = scanner.nextLine();
        }

        int number = Integer.parseInt(scanner.nextLine());
        Person personForCompare = people.get(number - 1);
        people.remove(number - 1);

        int countEqual = 1;
        for (Person person : people){
            if (personForCompare.compareTo(person) == 0){
                countEqual++;
            }
        }

        if (countEqual == 1){
            System.out.println("No matches");
        }else {
            System.out.println(countEqual + " " + (people.size() + 1 - countEqual) + " " + (people.size() + 1));
        }
    }
}
