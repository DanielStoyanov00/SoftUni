package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class _08WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[rows][];

        for (int i = 0; i < rows; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] valueIndexes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        int wrongsValue = matrix[valueIndexes[0]][valueIndexes[1]];


        List<int[]> indexes = new ArrayList<>();
        List<Integer> correctValues = new ArrayList<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == wrongsValue) {
                    indexes.add(new int[]{row, col});
                    correctValues.add(getCorrectValue(matrix, row, col));

                }
            }
        }
        for (int i = 0; i < indexes.size(); i++) {
            int[] rowAndCow = indexes.get(i);
            matrix[rowAndCow[0]][rowAndCow[1]] = correctValues.get(i);
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int row, int col) {
        int sum = 0;
        int wrongsValue = matrix[row][col];

        if (isInBounds(matrix, row - 1, col) && wrongsValue != matrix[row - 1][col]) {
            sum += matrix[row - 1][col];
        }

        if (isInBounds(matrix, row + 1, col) && wrongsValue != matrix[row + 1][col]) {
            sum += matrix[row + 1][col];
        }

        if (isInBounds(matrix, row, col - 1) && wrongsValue != matrix[row][col - 1]) {
            sum += matrix[row][col - 1];
        }

        if (isInBounds(matrix, row, col + 1) && wrongsValue != matrix[row][col + 1]) {
            sum += matrix[row][col + 1];
        }

        return sum;
    }

    private static boolean isInBounds(int[][] matrix, int row, int col) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }

}
