package com.company;

import java.util.Scanner;

public class _02Python {
    public static int row, col;
    public static int initialSnakeSize = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(", ");
        char[][] field = readMatrix(scanner, size);

        int goalFood = 1;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 's') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'f') {
                    goalFood++;
                }
            }
        }

        boolean hasItSteppedOnE = false;
        for (int i = 0; i < commands.length; i++) {
            String command = commands[i];
            switch (command) {
                case "left":
                    if (moveLeft(field)) {
                        hasItSteppedOnE = true;
                    }
                    break;
                case "right":
                    if (moveRight(field)) {
                        hasItSteppedOnE = true;
                    }
                    break;
                case "up":
                    if (moveUp(field)) {
                        hasItSteppedOnE = true;
                    }
                    break;
                case "down":
                    if (moveDown(field)) {
                        hasItSteppedOnE = true;
                    }
                    break;
            }

            if (hasItSteppedOnE) {
                System.out.println("You lose! Killed by an enemy!");
                return;
            }

            if (initialSnakeSize == goalFood) {
                System.out.printf("You win! Final python length is %d", initialSnakeSize);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", goalFood - initialSnakeSize);
    }


    private static boolean moveLeft(char[][] field) {
        if (col - 1 < 0) {
            col = field.length;
        }

        if (field[row][col - 1] == 'f') {
            initialSnakeSize++;
            field[row][col - 1] = '*';
        } else if (field[row][col - 1] == 'e') {
            return true;
        }

        col--;
        return false;
    }

    private static boolean moveRight(char[][] field) {
        if (col + 1 >= field.length) {
            col = -1;
        }

        if (field[row][col + 1] == 'f') {
            initialSnakeSize++;
            field[row][col + 1] = '*';
        } else if (field[row][col + 1] == 'e') {
            return true;
        }

        col++;
        return false;
    }

    private static boolean moveUp(char[][] field) {
        if (row - 1 < 0) {
            row = field.length;
        }

        if (field[row - 1][col] == 'f') {
            initialSnakeSize++;
            field[row - 1][col] = '*';
        } else if (field[row - 1][col] == 'e') {
            return true;
        }

        row--;
        return false;
    }

    private static boolean moveDown(char[][] field) {
        if (row + 1 >= field.length) {
            row = -1;
        }

        if (field[row + 1][col] == 'f') {
            initialSnakeSize++;
            field[row + 1][col] = '*';
        } else if (field[row + 1][col] == 'e') {
            return true;
        }

        row++;
        return false;
    }

    private static char[][] readMatrix(Scanner scanner, int size) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] eachRow = scanner.nextLine().split("\\s+");
            for (int c = 0; c < eachRow.length; c++) {
                char symbol = eachRow[c].charAt(0);
                matrix[r][c] = symbol;
            }
        }
        return matrix;
    }
}