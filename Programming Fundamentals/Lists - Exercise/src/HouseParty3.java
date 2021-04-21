import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HouseParty3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<String> names = new ArrayList<>();


        for (int i = 0; i < numberOfPeople; i++) {
            String input = scanner.nextLine();
            String[] inputAsArray = input.split(" ");
            String name = inputAsArray[0];

            if (inputAsArray.length == 3){
                if (names.contains(name)){
                    System.out.println(name + " is already in the list!");
                }else {
                    names.add(name);
                }
            }else {
                if (!names.remove(name)){
                    System.out.println(name + " is not in the list!");
                }
            }
        }

        for (String name : names){
            System.out.println(name);
        }


    }



}
