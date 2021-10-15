import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02ReVolt {
    public static int row, col;
    public static int finishRow, finishCol;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(reader.readLine());
        int numberOfCommands = Integer.parseInt(reader.readLine());

        char[][] field = createMatrix(matrixSize, reader);
        getInitialRowColForPlayerAndFinishRowCol(field);

        boolean hasWon;
        while (numberOfCommands-- > 0) {
            String command = reader.readLine();

            switch (command) {
                case "left":
                    move(row, col - 1, row, col - 2, row, field.length - 1, field);
                    break;
                case "right":
                    move(row, col + 1, row, col + 2, row, 0, field);
                    break;
                case "up":
                    move(row - 1, col, row - 2, col, field.length - 1, col, field);
                    break;
                case "down":
                    move(row + 1, col, row + 2, col, 0, col, field);
                    break;
            }

            hasWon = row == finishRow && col == finishCol;
            if (hasWon) {
                System.out.println("Player won!");
                printMatrix(field);
                return;
            }

        }
        System.out.println("Player lost!");
        printMatrix(field);
    }

    private static void printMatrix(char[][] field) {
        for (char[] chars : field) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] field) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
    }

    private static void move(int newRow, int newCol, int rowAfterStepOnBonus, int colAfterStepOnBonus,
                             int rowIfItsOutOfBounds, int colIfItsOutOfBounds, char[][] field) {
        if (isOutOfBounds(newRow, newCol, field)) {
            char symbol = field[rowIfItsOutOfBounds][colIfItsOutOfBounds];
            if (symbol == 'B') {
                field[row][col] = '-';
                field[rowAfterStepOnBonus][colAfterStepOnBonus] = 'f';
                row = rowAfterStepOnBonus;
                col = colAfterStepOnBonus;
            } else if (symbol != 'T') {
                field[row][col] = '-';
                row = rowIfItsOutOfBounds;
                col = colIfItsOutOfBounds;
                field[rowIfItsOutOfBounds][colIfItsOutOfBounds] = 'f';
            }
        } else {
            char symbol = field[newRow][newCol];
            if (symbol == 'B') {
                field[row][col] = '-';
                if (isOutOfBounds(rowAfterStepOnBonus, colAfterStepOnBonus, field)) {
                    row = rowIfItsOutOfBounds;
                    col = colIfItsOutOfBounds;
                    field[rowIfItsOutOfBounds][colIfItsOutOfBounds] = 'f';
                } else {
                    row = rowAfterStepOnBonus;
                    col = colAfterStepOnBonus;
                    field[rowAfterStepOnBonus][colAfterStepOnBonus] = 'f';
                }
            } else if (symbol != 'T') {
                field[row][col] = '-';
                field[newRow][newCol] = 'f';
                row = newRow;
                col = newCol;
            }
        }
    }

    private static void getInitialRowColForPlayerAndFinishRowCol(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'f') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'F') {
                    finishRow = r;
                    finishCol = c;
                }
            }
        }
    }

    private static char[][] createMatrix(int matrixSize, BufferedReader reader) throws IOException {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            matrix[r] = reader.readLine().toCharArray();
        }
        return matrix;
    }
}