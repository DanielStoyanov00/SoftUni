import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02Bee {
    public static int row, col, pollinatedFlowers = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int rowsAndCols = Integer.parseInt(reader.readLine());

        char[][] field = readMatrix(reader, rowsAndCols);
        initialRowAndColForBee(field);

        boolean outOfBounds = false;
        String command = reader.readLine();
        while (!command.equals("End")) {

            switch (command) {
                case "left":
                    outOfBounds = moveBee(row, col - 1, row, col - 2, field);
                    break;
                case "right":
                    outOfBounds = moveBee(row, col + 1, row, col + 2, field);
                    break;
                case "up":
                    outOfBounds = moveBee(row - 1, col, row - 2, col, field);
                    break;
                case "down":
                    outOfBounds = moveBee(row + 1, col, row + 2, col, field);
                    break;
            }


            if (outOfBounds) {
                System.out.println("The bee got lost!");
                break;
            }
            command = reader.readLine();
        }

        String output = pollinatedFlowers >= 5
                ? String.format("Great job, the bee manage to pollinate %d flowers!", pollinatedFlowers)
                : String.format("The bee couldn't pollinate the flowers, she needed %d flowers more", 5 - pollinatedFlowers);

        System.out.println(output);
        printMatrix(field);


    }

    private static char[][] readMatrix(BufferedReader reader, int rowsAndCols) throws IOException {
        char[][] matrix = new char[rowsAndCols][rowsAndCols];
        for (int row = 0; row < rowsAndCols; row++) {
            matrix[row] = reader.readLine().toCharArray();
        }
        return matrix;
    }

    private static void initialRowAndColForBee(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'B') {
                    row = r;
                    col = c;
                    break;
                }
            }
        }
    }

    private static boolean isOutOfBounds(int row, int col, char[][] field) {
        return row < 0 || row >= field.length || col < 0 || col >= field[row].length;
    }

    private static boolean moveBee(int newRow, int newCol, int rowForBonus, int colForBonus, char[][] field) {
        if (isOutOfBounds(newRow, newCol, field)) {
            field[row][col] = '.';
            return true;
        }

        char symbol = field[newRow][newCol];
        if (symbol == '.') {
            field[row][col] = '.';
            field[newRow][newCol] = 'B';
            row = newRow;
            col = newCol;
        } else if (symbol == 'f') {
            field[row][col] = '.';
            field[newRow][newCol] = 'B';
            pollinatedFlowers++;
            row = newRow;
            col = newCol;
        } else if (symbol == 'O') {
            if (field[rowForBonus][colForBonus] == 'f'){
                pollinatedFlowers++;
            }
            field[row][col] = '.';
            field[newRow][newCol] = '.';
            field[rowForBonus][colForBonus] = 'B';
            row = rowForBonus;
            col = colForBonus;
        }
        return false;
    }

    private static void printMatrix(char[][] field){
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                System.out.print(field[r][c]);
            }
            System.out.println();
        }
    }
}
