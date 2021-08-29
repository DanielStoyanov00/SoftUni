package com.company;

import java.util.Scanner;

public class _02Selling {
    private static int row;
    private static int col;
    private static int money;
    private static int[] firstPillar = new int[]{-1, -1};
    private static int[] secondPillar = new int[]{-1, -1};


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
                if (field[r][c] == 'O' && firstPillar[0] == -1) {
                    firstPillar[0] = r;
                    firstPillar[1] = c;
                } else if (field[r][c] == 'O' && firstPillar[0] != -1) {
                    secondPillar[0] = r;
                    secondPillar[1] = c;
                }
            }
        }

        String command = scanner.nextLine();
        while (money < 50) {
            boolean isOutOfField = false;
            switch (command) {
                case "left":
                    if (!move(row, col - 1, field)) {
                        isOutOfField = true;
                    }
                    break;
                case "right":
                    if (!move(row, col + 1, field)) {
                        isOutOfField = true;
                    }
                    break;
                case "up":
                    if (!move(row - 1, col, field)) {
                        isOutOfField = true;
                    }
                    break;
                case "down":
                    if (!move(row + 1, col, field)) {
                        isOutOfField = true;
                    }
                    break;
            }
            if (isOutOfField) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            } else if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            }
            command = scanner.nextLine();
        }

        System.out.printf("Money: %d\n", money);
        printMatrix(field);
    }

    private static boolean isInBounds(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static boolean move(int newRow, int newCol, char[][] field) {
        if (isInBounds(newRow, newCol, field)) {
            char symbol = field[newRow][newCol];
            if (symbol == '-') {
                field[row][col] = '-';
                field[newRow][newCol] = 'S';
                row = newRow;
                col = newCol;
            } else if (Character.isDigit(symbol)) {
                money += Character.getNumericValue(symbol);
                field[row][col] = '-';
                field[newRow][newCol] = 'S';
                row = newRow;
                col = newCol;
            } else if (symbol == 'O') {
                field[row][col] = '-';
                field[newRow][newCol] = '-';
                field[secondPillar[0]][secondPillar[1]] = 'S';
                row = secondPillar[0];
                col = secondPillar[1];
            }
            return true;
        } else {
            field[row][col] = '-';
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