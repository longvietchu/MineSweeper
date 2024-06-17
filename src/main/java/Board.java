import java.util.Random;

public class Board {
    private final int rows;
    private final int cols;
    private final int totalMines;
    private boolean isBoardUpdated;
    private Square[][] squares;

    public Board(int rows, int cols, int totalMines) {
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.isBoardUpdated = false;
        this.squares = new Square[rows][cols];
        this.initializeBoard();
        this.placeMines();
        this.calculateAdjacentMines();
    }

    /**
     * Initializes the board by creating a new Square object for each square.
     */
    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.squares[i][j] = new Square();
            }
        }
    }

    /**
     * Places mines randomly on the board.
     */
    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < this.totalMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!this.squares[r][c].isMine()) {
                this.squares[r][c].setMine(true);
                placedMines++;
            }
        }
    }

    /**
     * Counts the number of mines adjacent to a given square.
     *
     * @param row the row of the square.
     * @param col the column of the square.
     * @return the number of adjacent mines.
     */
    private int countAdjacentMines(int row, int col) {
            int count = 0;
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int newRow = row + i;
                    int newCol = col + j;
                    if (this.isValidSquare(newRow, newCol) && this.squares[newRow][newCol].isMine()) {
                        count++;
                    }
                }
            }
            return count;
    }

    /**
     * Calculates the number of adjacent mines for each square on the board.
     */
    private void calculateAdjacentMines() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!this.squares[r][c].isMine()) {
                    this.squares[r][c].setAdjacentMines(this.countAdjacentMines(r, c));
                }
            }
        }
    }

    /**
     * Checks if the specified row and column indices are within the bounds of the board.
     *
     * @param r the row index.
     * @param c the column index.
     * @return true if the indices are valid, false otherwise.
     */
    public boolean isValidSquare(int r, int c) {
        return r >= 0 && r < this.rows && c >= 0 && c < this.cols;
    }

    /**
     * Reveals the square at the specified row and column.
     * If the square has no adjacent mines, recursively reveals adjacent squares.
     *
     * @param r the row index.
     * @param c the column index.
     */
    public void revealSquare(int r, int c) {
        if (!isValidSquare(r, c) || squares[r][c].isRevealed()) return;
        squares[r][c].reveal();
        this.isBoardUpdated = true;
        if (squares[r][c].getAdjacentMines() == 0 && !squares[r][c].isMine()) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealSquare(r + i, c + j);
                }
            }
        }
    }

    /**
     * Prints the board to the console without revealing all the squares.
     */
    public void printBoard() {
        printBoard(false);
    }

    /**
     * Prints the board to the console.
     * Reveals all squares if the revealAll parameter is true.
     *
     * @param revealAll if true, reveals all squares on the board.
     */
    public void printBoard(boolean revealAll) {
        if (this.getIsBoardUpdated()) {
            System.out.println("Here is your updated minefield:");
        } else {
            System.out.println("Here is your minefield:");
        }

        for (int c = 0; c < this.cols + 1; c++) {
            if (c == 0) {
                System.out.print("  ");
            } else {
                System.out.print(c + " ");
            }
        }
        System.out.println();
        for (int r = 0; r < this.rows; r++) {
            System.out.print((char)('A' + r) + " ");
            for (int c = 0; c < this.cols; c++) {
                Square square = this.getSquare(r, c);
                if (revealAll || square.isRevealed()) {
                    if (square.isMine()) {
                        System.out.print("* ");
                    } else {
                        System.out.print(square.getAdjacentMines() + " ");
                    }
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Checks if the board has been updated.
     *
     * @return true if the board has been updated, false otherwise.
     */
    public boolean getIsBoardUpdated() {
        return this.isBoardUpdated;
    }

    /**
     * Gets the square at the specified row and column.
     *
     * @param r the row index.
     * @param c the column index.
     * @return the square at the specified row and column.
     */
    public Square getSquare(int r, int c) {
        return this.squares[r][c];
    }

    /**
     * Gets the number of rows on the board.
     *
     * @return the number of rows.
     */
    public int getRows() {
        return this.rows;
    }

    /**
     * Gets the number of columns on the board.
     *
     * @return the number of columns.
     */
    public int getCols() {
        return this.cols;
    }

    /**
     * Checks if there is a mine at a square with the specified row and column.
     *
     * @param r the row index.
     * @param c the column index.
     * @return true if there is a mine at the specified location, false otherwise.
     */
    public boolean isMineAt(int r, int c) {
        return this.squares[r][c].isMine();
    }
}
