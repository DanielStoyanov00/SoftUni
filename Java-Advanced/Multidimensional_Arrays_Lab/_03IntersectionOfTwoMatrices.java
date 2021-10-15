package com.company;
import java.util.Scanner;

public class _03IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] firstMatrix = createMatrix(scanner,rows,cols);
        char[][] secondMatrix = createMatrix(scanner,rows,cols);
        char[][] result = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                result[row][col] = firstMatrix[row][col] == secondMatrix[row][col]
                        ? firstMatrix[row][col]
                        : '*';
            }
        }
        printResult(result,rows,cols);
    }

    private static void printResult(char[][] result, int rows, int cols){
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(result[row][col] + " ");
            }
            System.out.println();
        }
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
