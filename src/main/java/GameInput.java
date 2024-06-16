import java.util.Scanner;

public class GameInput {
    private final Scanner scanner;

    public GameInput() {
        this.scanner = new Scanner(System.in);
    }

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

    public String selectSquare() {
        while (true) {
            System.out.print("Select a square to reveal (e.g., A1): ");
            String square = scanner.next().toUpperCase();
            if (square.length() != 2 ||
                    !Character.isAlphabetic(square.charAt(0)) ||
                    !Character.isDigit(square.charAt(1))) {
                System.out.println("Incorrect input.");
                continue;
            }
            return square;
        }
    }

    public String inputAnyKey() {
        System.out.print("Want to play again? (y/n): ");
        while (true) {
            String input = scanner.next();
            if (!input.equals("y") && !input.equals("n")) {
                continue;
            }
            return input;
        }
    }
}
