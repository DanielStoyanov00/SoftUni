package com.company;

import java.util.*;

public class _03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rowsAndCols = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(scanner,rowsAndCols);

        int primaryDiagonal = primaryDiagonal(matrix,rowsAndCols);
        int secondDiagonal = secondDiagonal(matrix,rowsAndCols);

        System.out.println(getAbsoluteDifference(primaryDiagonal,secondDiagonal));
    }

    private static int[][] readMatrix(Scanner scanner, int rowsAndCols) {
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    private static int primaryDiagonal(int[][] matrix, int rowsAndCols) {
        int primaryDiagonalSum = 0;
        int col = 0;
        for (int row = 0; row < rowsAndCols && col < rowsAndCols; row++, col++) {
            primaryDiagonalSum += matrix[row][col];
        }
        return primaryDiagonalSum;
    }

    private static int secondDiagonal(int[][] matrix, int rowsAndCols) {
        int secondDiagonalSum = 0;
        int col = 0;
        for (int row = rowsAndCols - 1; row >= 0 && col < rowsAndCols; row--, col++) {
            secondDiagonalSum += matrix[row][col];
        }
        return secondDiagonalSum;
    }

    private static int getAbsoluteDifference(int primaryDiagonalSum, int secondDiagonalSum){
        return Math.abs(primaryDiagonalSum - secondDiagonalSum);
    }
}
