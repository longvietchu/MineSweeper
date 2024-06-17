public class Game {
    private Board board;
    private boolean gameOver;
    private int gridSize;
    private final InputHandler inputHandler;

    public Game() {
        this.inputHandler = new InputHandler();
    }

    /**
     * Entry point to manage the game.
     * Sets up the game, manages the main game loop, and handles game restarts.
     */
    public void start() {
        this.setup();
        this.play();
        this.restart();
    }

    /**
     * Sets up the game by prompting the user for the grid size and the number of mines.
     * Initializes the board and sets the game state.
     */
    private void setup() {
        this.gridSize = this.inputHandler.inputGridSize();
        int totalMines = this.inputHandler.inputTotalMines(this.gridSize);
        this.gameOver = false;
        this.board = new Board(this.gridSize, this.gridSize, totalMines);
    }

    /**
     * Manages the main flow and rules of the game.
     * Continuously prompts the user to select squares until the game is won or a mine is detonated.
     */
    private void play() {
        while (!this.gameOver) {
            this.board.printBoard();
            int[] square = this.inputHandler.selectSquare(this.gridSize);
            int row = square[0];
            int col = square[1];
            if (this.board.isMineAt(row, col)) {
                this.gameOver = true;
                System.out.println("Oh no, you detonated a mine! Game over.");
            } else {
                this.board.revealSquare(row, col);
                System.out.println("This square contains " + this.board.getSquare(row, col).getAdjacentMines() + " adjacent mines.\n");
                if (this.isWin()) {
                    this.gameOver = true;
                    System.out.println("Congratulations, you have won the game!");
                }
            }
        }
        this.board.printBoard(true);
    }

    /**
     * Prompts the user to restart or end the game.
     * Restarts the game if the user chooses to continue, otherwise exits the game.
     */
    private void restart() {
        String input = this.inputHandler.inputRestartGame();
        if (input.equalsIgnoreCase("y")) {
            this.start();
        } else {
            System.out.println("Bye bye!!!");
        }
    }

    /**
     * Checks if the game has been won.
     * The game is won if all non-mine squares have been revealed.
     *
     * @return {@code true} if the game has been won, otherwise {@code false}.
     */
    protected boolean isWin() {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                Square square = board.getSquare(r, c);
                if (!square.isMine() && !square.isRevealed()) return false;
            }
        }
        return true;
    }
}
