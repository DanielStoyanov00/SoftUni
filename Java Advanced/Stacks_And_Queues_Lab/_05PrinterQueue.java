import java.util.*;

public class _05PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> printerQueue = new ArrayDeque<>();

        String input;
        while (!"print".equals(input = scanner.nextLine())) {
            if (input.equals("cancel")) {
                if (!printerQueue.isEmpty()) {
                    System.out.printf("Canceled %s\n", printerQueue.poll());
                } else {
                    System.out.println("Printer is on standby");
                }
            } else {
                printerQueue.offer(input);
            }
        }
        if (!printerQueue.isEmpty()) {
            printerQueue.forEach(System.out::println);
        }
    }
}
