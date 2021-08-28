package com.company;

import java.util.Scanner;

public class _02CookingJourney {
    public static int row, col, money;
    public static int[] firstPillar = new int[]{-1, -1};
    public static int[] secondPillar = new int[]{-1, -1};


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        char[][] field = readMatrix(size, scanner);

        for (int r = 0; r < size; r++) {
            for (int c = 0; c < size; c++) {
                if (field[r][c] == 'S') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'P' && firstPillar[0] == -1) {
                    firstPillar[0] = r;
                    firstPillar[1] = c;
                } else if (field[r][c] == 'P' && firstPillar[0] != -1) {
                    secondPillar[0] = r;
                    secondPillar[1] = c;
                }
            }
        }


        boolean outOfBounds = false;
        while (money < 50) {
            String command = scanner.nextLine();
            switch (command) {
                case "left":
                    if (isOutOfBounds(field, row, col - 1)) {
                        outOfBounds = true;
                        field[row][col] = '-';
                    } else {
                        moveLeft(field);
                    }
                    break;
                case "right":
                    if (isOutOfBounds(field, row, col + 1)) {
                        outOfBounds = true;
                        field[row][col] = '-';
                    } else {
                        moveRight(field);
                    }
                    break;
                case "up":
                    if (isOutOfBounds(field, row - 1, col)) {
                        outOfBounds = true;
                        field[row][col] = '-';
                    } else {
                        moveUp(field);
                    }
                    break;
                case "down":
                    if (isOutOfBounds(field, row + 1, col)) {
                        outOfBounds = true;
                        field[row][col] = '-';
                    } else {
                        moveDown(field);
                    }
                    break;
            }
            if (outOfBounds) {
                System.out.println("Bad news! You are out of the pastry shop.");
                break;
            }
        }

        if (money >= 50) {
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d\n", money);
        printMatrix(field);


    }

    private static void moveLeft(char[][] field) {
        char symbol = field[row][col - 1];
        if (Character.isDigit(symbol)) {
            money += Character.getNumericValue(symbol);
            field[row][col - 1] = 'S';
            field[row][col] = '-';
            col--;
        } else if (symbol == 'P') {
            field[row][col] = '-';
            field[firstPillar[0]][firstPillar[1]] = '-';
            field[secondPillar[0]][secondPillar[1]] = 'S';
            row = secondPillar[0];
            col = secondPillar[1];
        } else {
            field[row][col] = '-';
            field[row][col - 1] = 'S';
            col--;
        }
    }

    private static void moveRight(char[][] field) {
        char symbol = field[row][col + 1];
        if (Character.isDigit(symbol)) {
            money += Character.getNumericValue(symbol);
            field[row][col + 1] = 'S';
            field[row][col] = '-';
            col++;
        } else if (symbol == 'P') {
            field[row][col] = '-';
            field[firstPillar[0]][firstPillar[1]] = '-';
            field[secondPillar[0]][secondPillar[1]] = 'S';
            row = secondPillar[0];
            col = secondPillar[1];
        } else {
            field[row][col] = '-';
            field[row][col + 1] = 'S';
            col++;
        }
    }

    private static void moveUp(char[][] field) {
        char symbol = field[row - 1][col];
        if (Character.isDigit(symbol)) {
            money += Character.getNumericValue(symbol);
            field[row - 1][col] = 'S';
            field[row][col] = '-';
            row--;
        } else if (symbol == 'P') {
            field[row][col] = '-';
            field[firstPillar[0]][firstPillar[1]] = '-';
            field[secondPillar[0]][secondPillar[1]] = 'S';
            row = secondPillar[0];
            col = secondPillar[1];
        } else {
            field[row][col] = '-';
            field[row - 1][col] = 'S';
            row--;
        }
    }

    private static void moveDown(char[][] field) {
        char symbol = field[row + 1][col];
        if (Character.isDigit(symbol)) {
            money += Character.getNumericValue(symbol);
            field[row + 1][col] = 'S';
            field[row][col] = '-';
            row++;
        } else if (symbol == 'P') {
            field[row][col] = '-';
            field[firstPillar[0]][firstPillar[1]] = '-';
            field[secondPillar[0]][secondPillar[1]] = 'S';
            row = secondPillar[0];
            col = secondPillar[1];
        } else {
            field[row][col] = '-';
            field[row + 1][col] = 'S';
            row++;
        }

    }

    private static boolean isOutOfBounds(char[][] field, int row, int col) {
        return col < 0 || col >= field.length || row < 0 || row >= field.length;
    }

    private static char[][] readMatrix(int size, Scanner scanner) {
        char[][] matrix = new char[size][size];
        for (int r = 0; r < size; r++) {
            String[] eachRow = scanner.nextLine().split("");
            for (int c = 0; c < eachRow.length; c++) {
                matrix[r][c] = eachRow[c].charAt(0);
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
