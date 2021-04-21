import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        List<Integer> list = parseLineOfNumbers(line);

        String bombInfo = scanner.nextLine();
        String[] bombInfoAsArray = bombInfo.split(" ");

        int bombNumber = Integer.parseInt(bombInfoAsArray[0]);
        int power = Integer.parseInt(bombInfoAsArray[1]);

        while (list.contains(bombNumber)) {
            int bombPosition = list.indexOf(bombNumber);

            int leftBound = Math.max(0, bombPosition - power);
            int rightBound = Math.min(list.size() - 1, bombPosition + power);

            for (int i = rightBound; i >= leftBound; i--) {
                list.remove(i);

            }
        }

        int sum = 0;
        for (int number : list) {
            sum += number;
        }
        System.out.println(sum);


    }


    public static List<Integer> parseLineOfNumbers(String line) {

        String[] lineAsArray = line.split(" ");

        List<Integer> list = new ArrayList<>();

        for (String s : lineAsArray) {
            int number = Integer.parseInt(s);
            list.add(number);
        }
        return list;
    }
}
