package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _11ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] dimension = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(dimension[0]);
        int cols = Integer.parseInt(dimension[1]);

        int[][] matrix = readMatrix(scanner,rows,cols);

        if (matrix.length == 1){
            int[] arr = matrix[0];
            for (int i = arr.length - 1; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }else {
            int row = rows - 1;
            int col = cols - 1;
            System.out.println(matrix[row][col]);

        }
    }

    private static int[][] readMatrix(Scanner scanner,int rows, int cols){
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
