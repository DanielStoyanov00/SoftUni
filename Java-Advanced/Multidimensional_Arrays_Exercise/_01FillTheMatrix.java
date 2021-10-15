package com.company;

import java.util.*;

public class _01FillTheMatrix {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");
        int rowsAndCols = Integer.parseInt(input[0]);
        String type = input[1];

        if (type.equals("A")){
            printMatrix(createTypeA(rowsAndCols),rowsAndCols);
        }else if (type.equals("B")){
            printMatrix(createTypeB(rowsAndCols), rowsAndCols);
        }
    }

    private static int[][] createTypeA(int rowsAndCols) {
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        int startNumber = 1;
        for (int col = 0; col < rowsAndCols; col++) {
            for (int row = 0; row < rowsAndCols; row++) {
                matrix[row][col] = startNumber;
                startNumber++;
            }
        }
        return matrix;
    }

    private static int[][] createTypeB(int rowsAndCols) {
        int[][] matrix = new int[rowsAndCols][rowsAndCols];

        int startNumber = 1;
        for (int col = 0; col < rowsAndCols; col++) {
            if (col % 2 == 0){
                for (int row = 0; row < rowsAndCols; row++) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }else {
                for (int row = rowsAndCols - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber;
                    startNumber++;
                }
            }
        }
        return matrix;
    }

    private static void printMatrix(int [][] matrix, int rowsAndCols){
        for (int row = 0; row < rowsAndCols; row++) {
            for (int col = 0; col < rowsAndCols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}



