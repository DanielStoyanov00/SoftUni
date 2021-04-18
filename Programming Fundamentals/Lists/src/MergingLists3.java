import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingLists3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        ArrayList<Integer> firstFunction = new ArrayList<>(parseFirstLineOfNumbers(firstLine));
        ArrayList<Integer> secondFunction = new ArrayList<>(parseSecondLineOfNumbers(secondLine));


        ArrayList<Integer> mergedList = new ArrayList<>();

        if (firstFunction.size() >= secondFunction.size()) {
            for (int i = 0; i < firstFunction.size(); i++) {

                mergedList.add(firstFunction.get(i));
                if (i < secondFunction.size()) {
                    mergedList.add(secondFunction.get(i));
                }

            }
        } else {
            for (int i = 0; i < secondFunction.size(); i++) {
                if (i < firstFunction.size()) {
                    mergedList.add(firstFunction.get(i));
                }
                mergedList.add(secondFunction.get(i));

            }
        }


        for (int number : mergedList) {
            System.out.print(number + " ");
        }


    }

    public static List<Integer> parseFirstLineOfNumbers(String firstLine) {


        String[] firstLineAsArray = firstLine.split(" ");

        ArrayList<Integer> firstList = new ArrayList<>();

        for (String s : firstLineAsArray) {
            int number = Integer.parseInt(s);
            firstList.add(number);
        }
        return firstList;
    }

    public static List<Integer> parseSecondLineOfNumbers(String secondLine) {


        String[] secondLineAsArray = secondLine.split(" ");

        ArrayList<Integer> secondList = new ArrayList<>();


        for (String a : secondLineAsArray) {
            int number = Integer.parseInt(a);
            secondList.add(number);

        }
        return secondList;
    }


}
