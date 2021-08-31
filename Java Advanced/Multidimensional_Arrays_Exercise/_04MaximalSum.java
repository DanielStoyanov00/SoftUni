package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        int[][] matrix = createMatrix(scanner, rows, cols);
        int[][] bestMatrix = new int[3][3];

        int maxSum = Integer.MIN_VALUE;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                int sum = 0;
                sum += matrix[row][col] + matrix[row][col + 1]
                        + matrix[row][col + 2] + matrix[row + 1][col]
                        + matrix[row + 1][col + 1] + matrix[row + 1][col + 2]
                        + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
                if (sum > maxSum){
                    maxSum = sum;
                    bestMatrix[0][0] = matrix[row][col];
                    bestMatrix[0][1] = matrix[row][col + 1];
                    bestMatrix[0][2] = matrix[row][col + 2];
                    bestMatrix[1][0] = matrix[row + 1][col];
                    bestMatrix[1][1] = matrix[row + 1][col + 1];
                    bestMatrix[1][2] = matrix[row + 1][col + 2];
                    bestMatrix[2][0] = matrix[row + 2][col];
                    bestMatrix[2][1] = matrix[row + 2][col + 1];
                    bestMatrix[2][2] = matrix[row + 2][col + 2];
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        for (int row = 0; row < bestMatrix.length; row++) {
            for (int col = 0; col < bestMatrix.length; col++) {
                System.out.print(bestMatrix[row][col] + " ");
            }
            System.out.println();
        }

    }

    private static int[][] createMatrix(Scanner scanner, int rows, int cols) {

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
