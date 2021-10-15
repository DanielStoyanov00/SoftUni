package com.company;

import java.util.Scanner;

public class _02Snake {
    private static int row;
    private static int col;
    private static int food;
    private static int[] firstBurrow = new int[]{-1, -1};
    private static int[] secondBurrow = new int[]{-1, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = readMatrix(size, scanner);

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'S') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'B' && firstBurrow[0] == -1) {
                    firstBurrow[0] = r;
                    firstBurrow[1] = c;
                } else if (field[r][c] == 'B' && firstBurrow[0] != -1) {
                    secondBurrow[0] = r;
                    secondBurrow[1] = c;
                }
            }
        }
        boolean isOutOfField = false;
        String command = scanner.nextLine();
        while (food < 10) {
            switch (command) {
                case "left":
                    if (isOutOfBounds(row, col - 1, field)){
                        isOutOfField = true;
                    }else {
                        moveSnake(row, col - 1, field);
                    }
                    break;
                case "right":
                    if (isOutOfBounds(row, col + 1, field)){
                        isOutOfField = true;
                    }else {
                        moveSnake(row, col + 1, field);
                    }
                    break;
                case "up":
                    if (isOutOfBounds(row - 1, col, field)){
                        isOutOfField = true;
                    }else {
                        moveSnake(row - 1, col, field);
                    }
                    break;
                case "down":
                    if (isOutOfBounds(row + 1, col, field)){
                        isOutOfField = true;
                    }else {
                        moveSnake(row + 1, col, field);
                    }
                    break;
            }

            if (isOutOfField){
                System.out.println("Game over!");
                break;
            }else if (food >= 10){
                System.out.println("You won! You fed the snake.");
                break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("Food eaten: %d\n", food);
        printMatrix(field);
    }

    private static void moveSnake(int newRow, int newCol, char[][] field) {
        char symbol = field[newRow][newCol];
        if (symbol == 'B') {
            field[row][col] = '.';
            field[newRow][newCol] = '.';
            field[secondBurrow[0]][secondBurrow[1]] = 'S';
            row = secondBurrow[0];
            col = secondBurrow[1];
        } else {
            if (symbol == '*') {
                food++;
            }
            field[newRow][newCol] = 'S';
            field[row][col] = '.';
            row = newRow;
            col = newCol;
        }
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] field) {
        if (newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length) {
            field[row][col] = '.';
            return true;
        }
        return false;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];

        for (int r = 0; r < size; r++) {
            String[] line = scanner.nextLine().split("");
            for (int c = 0; c < line.length; c++) {
                matrix[r][c] = line[c].charAt(0);
            }
        }
        return matrix;
    }

    private static void printMatrix(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
