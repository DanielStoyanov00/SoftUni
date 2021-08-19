package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class _06PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        int[][] matrix = createMatrix(scanner,number);

        int row = 0;
        int col = 0;
        while (row < number && col < number){
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }

        System.out.println();

        row = number - 1;
        col = 0;
        while (row >= 0 && col < number){
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }

    private static int[][] createMatrix(Scanner scanner, int number){
        int[][] matrix = new int[number][number];

        for (int row = 0; row < number; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        return matrix;
    }
}
