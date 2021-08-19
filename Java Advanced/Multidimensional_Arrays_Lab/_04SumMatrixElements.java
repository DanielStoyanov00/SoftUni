package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _04SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = createMatrix(scanner, rows, cols);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(getSum(matrix,rows,cols));


    }

    private static int[][] createMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }

    public static int getSum(int[][] matrix, int rows, int cols){
        int sum = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }
}
