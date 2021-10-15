import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        List<Integer> list = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        while (true) {
            String line = scanner.nextLine();


            if (line.equals("end")) {
                break;
            }
            String[] lineAsArray = line.split(" ");

            switch (lineAsArray[0]) {
                case "Add":
                    int numberToAdd = Integer.parseInt(lineAsArray[1]);
                    list.add(numberToAdd);
                    break;
                case "Remove":
                    int numberToRemove = Integer.parseInt(lineAsArray[1]);
                    list.remove((Object) numberToRemove);
                    break;
                case "RemoveAt":
                    int indexToRemove = Integer.parseInt(lineAsArray[1]);
                    list.remove(indexToRemove);
                    break;
                case "Insert":
                    int number = Integer.parseInt(lineAsArray[1]);
                    int index = Integer.parseInt(lineAsArray[2]);
                    list.add(index, number);
                    break;
            }

        }

        for (int number : list) {
            System.out.print(number + " ");
        }


    }


}
