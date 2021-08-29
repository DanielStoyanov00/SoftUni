package com.company;

import java.util.Scanner;

public class _02Bomb {
    private static int row, col, bombs;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");
        char[][] field = readMatrix(size, scanner);

        int numberOfNeededBombs = 0;
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 's') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'B') {
                    numberOfNeededBombs++;
                }
            }
        }
        boolean gameEnds = false;

        for (String currentCommand : commands) {
            boolean findBomb = false;
            switch (currentCommand) {
                case "left":
                    if (!isOutOfBounds(field, row, col - 1)) {
                        if (itsOnE(field, row, col - 1)) {
                            gameEnds = true;
                        } else {
                            if (moveSapper(field, row, col - 1)) {
                                moveSapper(field, row, col - 1);
                                findBomb = true;
                            }
                            col--;
                        }
                    }
                    break;
                case "right":
                    if (!isOutOfBounds(field, row, col + 1)) {
                        if (itsOnE(field, row, col + 1)) {
                            gameEnds = true;
                        } else {
                            if (moveSapper(field, row, col + 1)) {
                                moveSapper(field, row, col + 1);
                                findBomb = true;
                            }
                            col++;
                        }
                    }
                    break;
                case "up":
                    if (!isOutOfBounds(field, row - 1, col)) {
                        if (itsOnE(field, row - 1, col)) {
                            gameEnds = true;
                        } else {
                            if (moveSapper(field, row - 1, col)) {
                                moveSapper(field, row - 1, col);
                                findBomb = true;
                            }
                            row--;
                        }
                    }
                    break;
                case "down":
                    if (!isOutOfBounds(field, row + 1, col)) {
                        if (itsOnE(field, row + 1, col)) {
                            gameEnds = true;
                        } else {
                            if (moveSapper(field, row + 1, col)) {
                                moveSapper(field, row + 1, col);
                                findBomb = true;
                            }
                            row++;
                        }
                    }
                    break;
            }
            if (findBomb) {
                System.out.println("You found a bomb!");
            }

            if (gameEnds) {
                System.out.printf("END! %d bombs left on the field", numberOfNeededBombs - bombs);
                return;
            } else if (bombs == numberOfNeededBombs) {
                System.out.print("Congratulations! You found all bombs!");
                return;
            }

        }

        if (bombs < numberOfNeededBombs) {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", numberOfNeededBombs - bombs, row, col);
        }

    }

    private static boolean moveSapper(char[][] field, int newRol, int newCol) {
        char symbol = field[newRol][newCol];
        if (symbol == 'B') {
            field[newRol][newCol] = 's';
            field[row][col] = '+';
            bombs++;
            return true;
        } else if (symbol == '+') {
            field[row][col] = '+';
            field[newRol][newCol] = 's';
        }
        return false;
    }

    private static boolean itsOnE(char[][] field, int newRow, int newCol) {
        return field[newRow][newCol] == 'e';
    }

    private static boolean isOutOfBounds(char[][] field, int newRow, int newCol) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];

        for (int r = 0; r < size; r++) {
            String[] eachRow = scanner.nextLine().split("\\s+");
            for (int c = 0; c < eachRow.length; c++) {
                matrix[r][c] = eachRow[c].charAt(0);
            }
        }
        return matrix;
    }
}
