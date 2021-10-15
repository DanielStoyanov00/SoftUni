package com.company;

import java.util.Scanner;

public class _02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] rowsAndCols = scanner.nextLine().split("\\s+");

        int rows = Integer.parseInt(rowsAndCols[0]);
        int cols = Integer.parseInt(rowsAndCols[1]);

        printMatrix(createMatrix(rows,cols),rows, cols);

    }
    private static String[][] createMatrix(int rows,int cols){
        String[][] matrix = new String[rows][cols];

        char firstLetter = 'a';
        for (int row = 0; row < rows; row++) {
            char second = firstLetter;
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = String.format("%c%c%c", firstLetter,second,firstLetter);
                second++;
            }
            firstLetter += 1;

        }
        return matrix;
    }

    private static void printMatrix(String[][] matrix, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
