package com.company;

import java.util.*;

public class _07Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        List<List<Integer>> matrix = readMatrix(rows, cols);

        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")) {
            String[] tokens = command.split("\\s+");

            int startRow = Integer.parseInt(tokens[0]);
            int startCol = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

            for (int i = startRow - radius; i <= startRow + radius; i++) {
                if (isInRange(i, startCol, matrix) && i != startRow) {
                    matrix.get(i).remove(startCol);
                }
            }

            for (int i = startCol + radius; i >= startCol - radius; i--) {
                if (isInRange(startRow, i, matrix)) {
                    matrix.get(startRow).remove(i);
                }
            }

            matrix.removeIf(List::isEmpty);
            command = scanner.nextLine();
        }

        for (List<Integer> integers : matrix) {
            for (Integer number : integers) {
                System.out.print(number + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> readMatrix(int rows, int cols) {

        List<List<Integer>> matrix = new ArrayList<>();
        int startNumber = 1;

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(startNumber++);
            }
        }
        return matrix;
    }

    private static boolean isInRange(int startRow, int startCol, List<List<Integer>> matrix) {
        return startRow >= 0 && startRow < matrix.size() && startCol >= 0 && startCol < matrix.get(startRow).size();
    }
}
