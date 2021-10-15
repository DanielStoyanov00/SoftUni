import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02Selling {
    public static int row,col;
    public static int money = 0;
    public static int[] firstPillarIndexes = new int[]{-1, -1};
    public static int[] secondPillarIndexes = new int[]{-1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rowsAndCols = Integer.parseInt(reader.readLine());

        char[][] field = createMatrix(rowsAndCols, reader);
        setInitialPositionOfRowColAndBothPillars(field);

        boolean isOutOfBounds = false;
        String command = reader.readLine();
        while (money < 50) {

            switch (command) {
                case "left":
                    isOutOfBounds = move(row, col - 1, field);
                    break;
                case "right":
                    isOutOfBounds = move(row, col + 1, field);
                    break;
                case "up":
                    isOutOfBounds = move(row - 1, col, field);
                    break;
                case "down":
                    isOutOfBounds = move(row + 1, col, field);
                    break;
            }

            if (money >= 50) {
                System.out.println("Good news! You succeeded in collecting enough money!");
                break;
            } else if (isOutOfBounds) {
                System.out.println("Bad news, you are out of the bakery.");
                break;
            }

            command = reader.readLine();
        }
        System.out.printf("Money: %d\n", money);
        printMatrix(field);

    }

    private static boolean move(int newRow, int newCol, char[][] field) {
        if (isOutOfBounds(field, newRow, newCol)) {
            field[row][col] = '-';
            return true;
        }
        char symbol = field[newRow][newCol];
        if (symbol == 'O') {
            field[row][col] = '-';
            field[newRow][newCol] = '-';
            row = secondPillarIndexes[0];
            col = secondPillarIndexes[1];
            field[row][col] = 'S';
        } else {
            if (Character.isDigit(symbol)) {
                money += Character.getNumericValue(symbol);
            }
            field[newRow][newCol] = 'S';
            field[row][col] = '-';
            row = newRow;
            col = newCol;
        }
        return false;
    }

    private static boolean isOutOfBounds(char[][] field, int newRow, int newCol) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
    }

    private static char[][] createMatrix(int rowsAndCols, BufferedReader reader) throws IOException {
        char[][] matrix = new char[rowsAndCols][rowsAndCols];
        for (int r = 0; r < matrix.length; r++) {
            matrix[r] = reader.readLine().toCharArray();
        }
        return matrix;
    }

    private static void printMatrix(char [][] field){
        for (char[] chars : field) {
            for (char currentSymbol : chars) {
                System.out.print(currentSymbol);
            }
            System.out.println();
        }
    }

    private static void setInitialPositionOfRowColAndBothPillars(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 'S') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'O' && firstPillarIndexes[0] == -1) {
                    firstPillarIndexes[0] = r;
                    firstPillarIndexes[1] = c;
                } else if (field[r][c] == 'O' && firstPillarIndexes[0] != -1) {
                    secondPillarIndexes[0] = r;
                    secondPillarIndexes[1] = c;
                }
            }
        }
    }
}