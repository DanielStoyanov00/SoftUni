import java.util.Scanner;

public class Elevator3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());


        int courses = numberOfPeople / capacity;

        if (numberOfPeople <= capacity){
            System.out.println("1");
        }else if (numberOfPeople % capacity == 0){
            System.out.println(courses);
        }else {
            courses += 1;
            System.out.println(courses);
        }
    }
}
