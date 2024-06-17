import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Prompts the user to input the size of the grid.
     * The grid size must be between 3 and 10.
     * Continues prompting until a valid size is entered.
     *
     * @return the size of the grid.
     */
    public int inputGridSize() {
        while (true) {
            System.out.println("Enter the size of the grid (e.g. 4 for a 4x4 grid):");
            if (!this.scanner.hasNextInt()) {
                this.scanner.next();
                System.out.println("Incorrect input.");
                continue;
            }
            int gridSize = this.scanner.nextInt();
            if (gridSize < 3) {
                System.out.println("Minimum size of grid is 3.");
                continue;
            }
            if (gridSize > 10) {
                System.out.println("Maximum size of grid is 10.");
                continue;
            }
            return gridSize;
        }
    }

    /**
     * Prompts the user to input the total number of mines to place on the grid.
     * The number of mines must be between 1 and 35% of the total number of grid squares.
     * Continues prompting until a valid number of mines is entered.
     *
     * @param gridSize the size of the grid.
     * @return the total number of mines.
     */
    public int inputTotalMines(int gridSize) {
        while (true) {
            System.out.println("Enter the number of mines to place on the grid (maximum is 35% of the total squares):");
            if (!this.scanner.hasNextInt()) {
                this.scanner.next();
                System.out.println("Incorrect input.");
                continue;
            }
            int totalMines = scanner.nextInt();
            int maxNumOfMines = gridSize * gridSize * 35 / 100;
            if (totalMines > maxNumOfMines) {
                System.out.println("Maximum number is 35% of total squares.");
                continue;
            }
            if (totalMines < 1) {
                System.out.println("There must be at least 1 mine.");
                continue;
            }
            return totalMines;
        }
    }

    /**
     * Prompts the user to select a square to reveal.
     * The input must be in the format "<char><int>", where the letter represents the row and the number represents the column.
     * Continues prompting until a valid square is selected.
     *
     * @param gridSize the size of the grid.
     * @return an array containing the row and column indices of the selected square.
     */
    public int[] selectSquare(int gridSize) {
        while (true) {
            System.out.print("Select a square to reveal (e.g., A1): ");
            String input = scanner.next().toUpperCase();
            if (input.length() != 2 ||
                    !Character.isAlphabetic(input.charAt(0)) ||
                    !Character.isDigit(input.charAt(1))) {
                System.out.println("Incorrect input.");
                continue;
            }
            int[] square = new int[2];
            square[0] = input.charAt(0) - 'A';
            square[1] = input.charAt(1) - '0' - 1;
            if (square[0] < 0 || square[0] >= gridSize ||
                    square[1] < 0 || square[1] >= gridSize) {
                System.out.println("Invalid square.");
                continue;
            }
            return square;
        }
    }

    /**
     * Prompts the user to input whether they want to restart the game.
     * Continues prompting until a valid input ("y" or "n") is entered.
     *
     * @return "y" if the user wants to restart, "n" otherwise.
     */
    public String inputRestartGame() {
        System.out.print("Want to play again? (y/n): ");
        while (true) {
            String input = scanner.next();
            if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("n")) continue;
            return input;
        }
    }
}
