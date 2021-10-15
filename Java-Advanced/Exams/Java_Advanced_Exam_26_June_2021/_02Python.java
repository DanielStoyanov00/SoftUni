import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _02Python {
    public static int row, col;
    public static int pythonInitialLength = 1;
    public static int initialGoalFood = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int matrixSize = Integer.parseInt(reader.readLine());
        String[] commands = reader.readLine().split(", ");
        char[][] field = createMatrix(matrixSize, reader);
        setInitialRowColAndFinalGoalFood(field);

        boolean isGameEnds = false;
        for (String command : commands) {
            switch (command) {
                case "left":
                    isGameEnds = moveSnake(row, col - 1, row, field.length - 1, field);
                    break;
                case "right":
                    isGameEnds = moveSnake(row, col + 1, row, 0, field);
                    break;
                case "up":
                    isGameEnds = moveSnake(row - 1, col, field.length - 1, col, field);
                    break;
                case "down":
                    isGameEnds = moveSnake(row + 1, col, field.length + 1, col, field);
                    break;
            }

            if (isGameEnds || pythonInitialLength == initialGoalFood) {
                String result = pythonInitialLength == initialGoalFood
                        ? String.format("You win! Final python length is %d", pythonInitialLength)
                        : "You lose! Killed by an enemy!";
                System.out.println(result);
                return;
            }
        }

        System.out.printf("You lose! There is still %d food to be eaten.", initialGoalFood - pythonInitialLength);

    }

    private static boolean moveSnake(int newRow, int newCol, int rowIfItsOutOfBounds, int colIfItsOutOfBounds, char[][] field) {
        if (isOutOfBounds(newRow, newCol, field)) {
            field[row][col] = '*';
            char symbol = field[rowIfItsOutOfBounds][colIfItsOutOfBounds];
            if (symbol == 'e') {
                return true;
            } else {
                if (symbol == 'f') {
                    pythonInitialLength++;
                }
                row = rowIfItsOutOfBounds;
                col = colIfItsOutOfBounds;
            }

        } else {
            char symbol = field[newRow][newCol];
            if (symbol == 'e') {
                return true;
            } else {
                if (symbol == 'f') {
                    pythonInitialLength++;
                }
                field[row][col] = '*';
                row = newRow;
                col = newCol;
                field[newRow][newCol] = 's';
            }
        }
        return false;
    }

    private static boolean isOutOfBounds(int newRow, int newCol, char[][] field) {
        return newRow < 0 || newRow >= field.length || newCol < 0 || newCol >= field[newRow].length;
    }

    private static void setInitialRowColAndFinalGoalFood(char[][] field) {
        for (int r = 0; r < field.length; r++) {
            for (int c = 0; c < field[r].length; c++) {
                if (field[r][c] == 's') {
                    row = r;
                    col = c;
                }
                if (field[r][c] == 'f') {
                    initialGoalFood++;
                }
            }
        }
    }

    private static char[][] createMatrix(int matrixSize, BufferedReader reader) throws IOException {
        char[][] matrix = new char[matrixSize][matrixSize];
        for (int r = 0; r < matrixSize; r++) {
            String[] currentCol = reader.readLine().split("\\s+");
            for (int c = 0; c < currentCol.length; c++) {
                matrix[r][c] = currentCol[c].charAt(0);
            }
        }
        return matrix;
    }
}