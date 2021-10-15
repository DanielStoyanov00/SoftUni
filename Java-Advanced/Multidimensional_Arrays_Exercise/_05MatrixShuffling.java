package com.company;
import java.util.*;

public class _05MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rows = input[0];
        int cols = input[1];

        String[][] matrix = readMatrix(scanner, rows, cols);

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] tokens = line.split(" ");

            swapMatrix(rows, cols, matrix, tokens);

            line = scanner.nextLine();
        }
    }

    private static void swapMatrix(int rows, int cols, String[][] matrix, String[] tokens) {

        if (tokens.length == 5) {
            if (tokens[0].equals("swap")) {
                int firstIndexForRow = Integer.parseInt(tokens[1]);
                int firstIndexForCol = Integer.parseInt(tokens[2]);
                int secondIndexForRow = Integer.parseInt(tokens[3]);
                int secondIndexForCol = Integer.parseInt(tokens[4]);

                if (isInBounds(rows, cols, firstIndexForRow, firstIndexForCol, secondIndexForRow, secondIndexForCol)) {
                    String firstValue = matrix[firstIndexForRow][firstIndexForCol];
                    String secondValue = matrix[secondIndexForRow][secondIndexForCol];

                    matrix[firstIndexForRow][firstIndexForCol] = secondValue;
                    matrix[secondIndexForRow][secondIndexForCol] = firstValue;

                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.print(matrix[row][col] + " ");
                        }
                        System.out.println();
                    }
                } else {
                    System.out.println("Invalid input!");
                }
            } else {
                System.out.println("Invalid input!");
            }
        } else {
            System.out.println("Invalid input!");
        }
    }

    public static String[][] readMatrix(Scanner scanner, int rows, int cols) {

        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
        return matrix;

    }

    public static boolean isInBounds(int rows, int cols, int firstIndexForRow, int firstIndexForCol, int secondIndexForRow, int secondIndexForCol) {

        return firstIndexForRow < rows && firstIndexForRow >= 0 && firstIndexForCol < cols && firstIndexForCol >= 0
                && secondIndexForRow < rows && secondIndexForRow >= 0 && secondIndexForCol < cols && secondIndexForCol >= 0;
    }
}
