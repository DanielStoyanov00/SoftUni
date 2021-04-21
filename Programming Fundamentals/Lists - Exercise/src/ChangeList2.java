import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();

        List<Integer> list = parseLineOfNumbers(line);


        while (true) {
            String input = scanner.nextLine();

            if (input.equals("end")) {
                break;
            }

            String[] inputAsArray = input.split(" ");


            if (inputAsArray[0].equals("Delete")) {
                int numberToDelete = Integer.parseInt(inputAsArray[1]);
                for (int i = list.size() - 1; i >= 0; i--) {
                    int currentNumber = list.get(i);
                    if (currentNumber == numberToDelete) {
                        list.remove(list.get(i));
                    }
                }
            } else if (inputAsArray[0].equals("Insert")) {
                int index = Integer.parseInt(inputAsArray[1]);
                int number = Integer.parseInt(inputAsArray[2]);

                list.add(number, index);
            }

        }
        for (int number : list) {
            System.out.print(number + " ");
        }


    }

    public static List<Integer> parseLineOfNumbers(String line) {

        String[] array = line.split(" ");

        ArrayList<Integer> list = new ArrayList<>();

        for (String s : array) {
            int number = Integer.parseInt(s);
            list.add(number);
        }
        return list;
    }
}
