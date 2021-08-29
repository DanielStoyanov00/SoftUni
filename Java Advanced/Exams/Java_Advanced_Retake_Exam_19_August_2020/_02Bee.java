package com.company;

import java.util.Scanner;

public class _02Bee {
    private static int row;
    private static int col;
    private static int pollinatedFlowers;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = readMatrix(size, scanner);

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'B') {
                    row = r;
                    col = c;
                    break;
                }
            }
        }
        boolean isOutOfField = false;
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "left":
                    if (isOutOfBounds(row, col - 1, field)) {
                        isOutOfField = true;
                    } else {
                        moveBee(row, col - 1, field, command);
                    }
                    break;
                case "right":
                    if (isOutOfBounds(row, col + 1, field)) {
                        isOutOfField = true;
                    } else {
                        moveBee(row, col + 1, field, command);
                    }
                    break;
                case "up":
                    if (isOutOfBounds(row - 1, col, field)) {
                        isOutOfField = true;
                    } else {
                        moveBee(row - 1, col, field, command);
                    }
                    break;
                case "down":
                    if (isOutOfBounds(row + 1, col, field)) {
                        isOutOfField = true;
                    } else {
                        moveBee(row + 1, col, field, command);
                    }
                    break;
            }
            if (isOutOfField) {
                System.out.println("The bee got lost!");
                break;
            }

            command = scanner.nextLine();
        }
        if (pollinatedFlowers < 5) {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more\n", 5 - pollinatedFlowers);
        } else {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!\n", pollinatedFlowers);
        }

        printMatrix(field);
    }

    private static void moveBee(int newRow, int newCol, char[][] field, String command) {
        if (isOutOfBounds(newRow, newCol, field)) {
            field[row][col] = '.';
        } else {
            char symbol = field[newRow][newCol];
            if (symbol == 'O') {
                field[row][col] = '.';
                field[newRow][newCol] = '.';
                switch (command) {
                    case "left":
                        int newColMinus = newCol - 1;
                        symbol = field[newRow][newColMinus];
                        if (symbol == 'f') {
                            pollinatedFlowers++;
                            field[newRow][newColMinus] = 'B';
                        } else if (symbol == '.') {
                            field[newRow][newColMinus] = 'B';
                        }
                        row = newRow;
                        col = newColMinus;
                        break;
                    case "right":
                        int newColPlus = newCol + 1;
                        symbol = field[newRow][newColPlus];
                        if (symbol == 'f') {
                            pollinatedFlowers++;
                            field[newRow][newColPlus] = 'B';
                        } else if (symbol == '.') {
                            field[newRow][newColPlus] = 'B';
                        }
                        row = newRow;
                        col = newColPlus;
                        break;
                    case "up":
                        int newRowMinus = newRow - 1;
                        symbol = field[newRowMinus][newCol];
                        if (symbol == 'f') {
                            pollinatedFlowers++;
                            field[newRowMinus][newCol] = 'B';
                        } else if (symbol == '.') {
                            field[newRowMinus][newCol] = 'B';
                        }
                        row = newRowMinus;
                        col = newCol;
                        break;
                    case "down":
                        int newRowPlus = newRow + 1;
                        symbol = field[newRowPlus][newCol];
                        if (symbol == 'f') {
                            pollinatedFlowers++;
                            field[newRowPlus][newCol] = 'B';
                        } else if (symbol == '.') {
                            field[newRowPlus][newCol] = 'B';
                        }
                        row = newRowPlus;
                        col = newCol;
                        break;
                }
            } else {
                if (symbol == 'f') {
                    pollinatedFlowers++;
                    field[row][col] = '.';
                    field[newRow][newCol] = 'B';
                } else if (symbol == '.') {
                    field[row][col] = '.';
                    field[newRow][newCol] = 'B';
                }
                row = newRow;
                col = newCol;
            }

        }
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] field) {
        field[row][col] = '.';
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
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