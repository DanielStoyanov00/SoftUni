package com.company;

import java.util.*;

public class _02ReVolt {
    public static int playerRow;
    public static int playerCol;
    public static int finishRow;
    public static int finishCol;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int commandsCount = Integer.parseInt(scanner.nextLine());

        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            if (line.contains("f")) {
                playerRow = i;
                playerCol = line.indexOf("f");
            }
            if (line.contains("F")) {
                finishRow = i;
                finishCol = line.indexOf("F");
            }
            field[i] = line.toCharArray();
        }

        boolean hasWon = false;

        while (commandsCount-- > 0 && !hasWon) {
            String command = scanner.nextLine();

            switch (command) {
                case "up":
                    moveUp(field);
                    break;
                case "down":
                    moveDown(field);
                    break;
                case "left":
                    moveLeft(field);
                    break;
                case "right":
                    moveRight(field);
                    break;
            }

            hasWon = playerRow == finishRow && playerCol == finishCol;
        }

        if (hasWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }

    private static void moveLeft(char[][] field) {
        int prevCol = playerCol;
        if (playerCol - 1 < 0) {
            playerCol = field.length;
        }
        if (field[playerRow][playerCol - 1] != 'T') {
            if (playerCol == field.length) {
                prevCol = 0;
            }
            field[playerRow][prevCol] = '-';
            playerCol--;
            if (field[playerRow][playerCol] == 'B') {
                int beforeRecursive = playerRow, beforeRecursiveCol = playerCol;
                moveLeft(field);
                field[beforeRecursive][beforeRecursiveCol] = 'B';
            }
            field[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveUp(char[][] field) {
        int prevRow = playerRow;
        if (playerRow - 1 < 0) {
            playerRow = field.length;
        }
        if (field[playerRow - 1][playerCol] != 'T') {
            if (playerRow == field.length) {
                prevRow = 0;
            }
            field[prevRow][playerCol] = '-';
            playerRow--;
            if (field[playerRow][playerCol] == 'B') {
                int beforeRecursive = playerRow, beforeRecursiveCol = playerCol;
                moveUp(field);
                field[beforeRecursive][beforeRecursiveCol] = 'B';
            }
            field[playerRow][playerCol] = 'f';
        } else {
            playerRow = prevRow;
        }
    }

    private static void moveRight(char[][] field) {
        int prevCol = playerCol;
        if (playerCol + 1 == field.length) {
            playerCol = -1;
        }
        if (field[playerRow][playerCol + 1] != 'T') {
            if (playerCol == -1) {
                prevCol = field.length - 1;
            }
            field[playerRow][prevCol] = '-';
            playerCol++;
            if (field[playerRow][playerCol] == 'B') {
                int beforeRecursive = playerRow, beforeRecursiveCol = playerCol;
                moveRight(field);
                field[beforeRecursive][beforeRecursiveCol] = 'B';
            }
            field[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveDown(char[][] field) {
        int prevRow = playerRow;
        if (playerRow + 1 == field.length) {
            playerRow = -1;
        }
        if (field[playerRow + 1][playerCol] != 'T') {
            if (playerRow == -1) {
                prevRow = field.length - 1;
            }
            field[prevRow][playerCol] = '-';
            playerRow++;
            if (field[playerRow][playerCol] == 'B') {
                int beforeRecursive = playerRow, beforeRecursiveCol = playerCol;
                moveDown(field);
                field[beforeRecursive][beforeRecursiveCol] = 'B';
            }
            field[playerRow][playerCol] = 'f';
        } else {
            playerRow = prevRow;
        }
    }
}
