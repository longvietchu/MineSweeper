public class Game {
    private Board board;
    private boolean gameOver;
    private final GameInput gameInput;

    public Game() {
        this.gameInput = new GameInput();
    }

    public void start() {
        this.setup();
        while (!this.gameOver) {
            this.printBoard();
            String input = this.gameInput.selectSquare();
            int row = input.charAt(0) - 'A';
            int col = input.charAt(1) - '0' - 1;
            if (this.board.isMineAt(row, col)) {
                this.gameOver = true;
                System.out.println("Oh no, you detonated a mine! Game over.");
            } else {
                this.board.revealCell(row, col);
                System.out.println("This square contains " + this.board.getCell(row, col).getAdjacentMines() + " adjacent mines.\n");
                if (this.isWin()) {
                    this.gameOver = true;
                    System.out.println("Congratulations, you have won the game!");
                }
            }
        }
        printBoard(true);
        this.restart();
    }

    private void setup() {
        int gridSize = this.gameInput.inputGridSize();
        int totalMines = this.gameInput.inputTotalMines(gridSize);
        this.gameOver = false;
        this.board = new Board(gridSize, gridSize, totalMines);
    }

    private void printBoard() {
        printBoard(false);
    }

    private void printBoard(boolean revealAll) {
        if (board.getIsBoardUpdated()) {
            System.out.println("Here is your updated minefield:");
        } else {
            System.out.println("Here is your minefield:");
        }

        for (int c = 0; c < board.getCols() + 1; c++) {
            if (c == 0) {
                System.out.print("  ");
            } else {
                System.out.print(c + " ");
            }
        }
        System.out.println();
        for (int r = 0; r < board.getRows(); r++) {
            System.out.print((char)('A' + r) + " ");
            for (int c = 0; c < board.getCols(); c++) {
                Cell cell = board.getCell(r, c);
                if (revealAll || cell.isRevealed()) {
                    if (cell.isMine()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(cell.getAdjacentMines() + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isWin() {
        for (int r = 0; r < board.getRows(); r++) {
            for (int c = 0; c < board.getCols(); c++) {
                Cell cell = board.getCell(r, c);
                if (!cell.isMine() && !cell.isRevealed()) {
                    return false;
                }
            }
        }
        return true;
    }

    private void restart() {
        String input = this.gameInput.inputAnyKey();
        if (input.equals("y")) {
            this.start();
        } else {
            System.out.println("Bye bye!!!");
        }
    }
}
