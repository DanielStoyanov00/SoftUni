import java.util.*;

public class _05Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(";");
        String[] robots = new String[input.length];
        int[] processTime = new int[input.length];
        int[] workTime = new int[input.length];

        for (int i = 0; i < input.length; i++) {
            String[] data = input[i].split("-");
            String name = data[0];
            int time = Integer.parseInt(data[1]);
            robots[i] = name;
            processTime[i] = time;
        }

        String startTime = scanner.nextLine();

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        String inputProduct = scanner.nextLine();

        while (!inputProduct.equals("End")) {
            productsQueue.offer(inputProduct);

            inputProduct = scanner.nextLine();
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int beginSeconds = hours * 3600 + minutes * 60 + seconds;

        while (!productsQueue.isEmpty()) {
            beginSeconds++;

            String product = productsQueue.poll();

            boolean isWorking = false;
            for (int i = 0; i < robots.length; i++) {
                if (workTime[i] == 0 && !isWorking) {
                    workTime[i] = processTime[i];
                    isWorking = true;
                    printRobotData(robots[i], product, beginSeconds);
                }
                if (workTime[i] > 0) {
                    workTime[i]--;
                }
            }

            if (!isWorking) {
                productsQueue.offer(product);
            }
        }

    }

    private static void printRobotData(String robot, String product, int beginSeconds) {
        long seconds = beginSeconds % 60;
        long minutes = (beginSeconds / 60) % 60;
        long hours = (beginSeconds / 3600) % 24;
        System.out.println(robot + " - " + product +
                String.format(" [%02d:%02d:%02d] ", hours, minutes, seconds));
    }
}
