import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02Bomb {
    public static int row, col;
    public static int neededDeactivatedBombs;
    public static int currentBombs;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rowsAndCols = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(",");
        char[][] field = createMatrix(rowsAndCols, reader);
        setRowColAndNeededBombs(field);

        boolean isGameEnds = false;
        for (String command : commands) {
            switch (command) {
                case "left":
                    isGameEnds = move(row, col - 1, field);
                    break;
                case "right":
                    isGameEnds = move(row, col + 1, field);
                    break;
                case "up":
                    isGameEnds = move(row - 1, col, field);
                    break;
                case "down":
                    isGameEnds = move(row + 1, col, field);
                    break;
            }

            if (isGameEnds) {
                String output = currentBombs == neededDeactivatedBombs
                        ? "Congratulations! You found all bombs!"
                        : String.format("END! %d bombs left on the field", neededDeactivatedBombs - currentBombs);
                System.out.println(output);
                return;
            }
        }

        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", neededDeactivatedBombs - currentBombs, row, col);

    }

    private static boolean move(int newRow, int newCol, char[][] field) {
        if (isInBounds(newRow, newCol, field)) {
            char symbol = field[newRow][newCol];
            if (symbol == 'B') {
                field[newRow][newCol] = '+';
                row = newRow;
                col = newCol;
                currentBombs++;
                System.out.println("You found a bomb!");
                return currentBombs == neededDeactivatedBombs;
            } else if (symbol == 'e') {
                return true;
            }
                row = newRow;
                col = newCol;

        }
        return false;
    }

    private static boolean isInBounds(int newRow, int newCol, char[][] field) {
        return newRow >= 0 && newRow < field.length && newCol >= 0 && newCol < field[newRow].length;
    }

    private static char[][] createMatrix(int rowsAndCols, BufferedReader reader) throws IOException {
        char[][] matrix = new char[rowsAndCols][rowsAndCols];
        for (int r = 0; r < matrix.length; r++) {
            String[] col = reader.readLine().split("\\s+");
            for (int c = 0; c < col.length; c++) {
                char symbol = col[c].charAt(0);
                matrix[r][c] = symbol;
            }
        }
        return matrix;
    }

    private static void setRowColAndNeededBombs(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 's') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'B') {
                    neededDeactivatedBombs++;
                }
            }
        }
    }
}