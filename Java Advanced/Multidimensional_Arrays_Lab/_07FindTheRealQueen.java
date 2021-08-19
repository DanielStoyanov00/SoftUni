package com.company;

import java.util.Scanner;

public class _07FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char[][] chessMatrix = createMatrix(scanner, 8, 8);

        for (int row = 0; row < chessMatrix.length; row++) {
            for (int col = 0; col < chessMatrix[row].length; col++) {
                char current = chessMatrix[row][col];
                if (current == 'q' && isValidQueen(chessMatrix, row, col)) {
                    System.out.print(row + " " + col);
                    return;
                }
            }
        }
    }

    private static boolean isValidQueen(char[][] chessMatrix, int row, int col) {
        // right horizontal
        for (int i = col + 1; i < 8; i++) {
            char charToCheck = chessMatrix[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        // left horizontal
        for (int i = col - 1; i >= 0; i--) {
            char charToCheck = chessMatrix[row][i];
            if (charToCheck == 'q') {
                return false;
            }
        }
        // upper vertical
        for (int i = row - 1; i >= 0; i--) {
            char charToCheck = chessMatrix[i][col];
            if (charToCheck == 'q') {
                return false;
            }
        }
        // lower vertical
        for (int i = row + 1; i < 8; i++) {
            char charToCheck = chessMatrix[i][col];
            if (charToCheck == 'q') {
                return false;
            }
        }
        int element = col - 1;
        // upper left
        for (int i = row - 1; i >= 0 && element >= 0; i--, element--) {
            char charToCheck = chessMatrix[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        element = col + 1;
        // upper right
        for (int i = row - 1; i >= 0 && element < 8; i--, element++) {
            char charToChek = chessMatrix[i][element];
            if (charToChek == 'q') {
                return false;
            }
        }
        element = col - 1;
        // lower left
        for (int i = row + 1; i < 8 && element >= 0; i++, element--) {
            char charToCheck = chessMatrix[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        element = col + 1;
        //lower right
        for (int i = row + 1; i < 8 && element < 8; i++, element++) {
            char charToCheck = chessMatrix[i][element];
            if (charToCheck == 'q') {
                return false;
            }
        }
        return true;
    }

    private static char[][] createMatrix(Scanner scanner, int rows, int cols) {
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] symbols = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = symbols[col].charAt(0);
            }
        }
        return matrix;
    }
}

