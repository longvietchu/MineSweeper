import java.util.Random;

public class Board {
    private final int rows;
    private final int cols;
    private final int totalMines;
    private boolean isBoardUpdated;
    private Cell[][] cells;

    public Board(int rows, int cols, int totalMines) {
        this.rows = rows;
        this.cols = cols;
        this.totalMines = totalMines;
        this.isBoardUpdated = false;
        this.cells = new Cell[rows][cols];
        this.initializeBoard();
        this.placeMines();
        this.calculateAdjacentMines();
    }

    private void initializeBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                this.cells[i][j] = new Cell();
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;
        while (placedMines < this.totalMines) {
            int r = rand.nextInt(rows);
            int c = rand.nextInt(cols);
            if (!this.cells[r][c].isMine()) {
                this.cells[r][c].setMine(true);
                placedMines++;
            }
        }
    }

    private void calculateAdjacentMines() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!this.cells[r][c].isMine()) {
                    int count = 0;
                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            int newRow = r + i;
                            int newCol = c + j;
                            if (this.isValidCell(newRow, newCol) && this.cells[newRow][newCol].isMine()) {
                                count++;
                            }
                        }
                    }
                    this.cells[r][c].setAdjacentMines(count);
                }
            }
        }
    }

    private boolean isValidCell(int r, int c) {
        return r >= 0 && r < this.rows && c >= 0 && c < this.cols;
    }

    public void revealCell(int r, int c) {
        if (!isValidCell(r, c) || cells[r][c].isRevealed()) {
            return;
        }
        cells[r][c].reveal();
        this.isBoardUpdated = true;
        if (cells[r][c].getAdjacentMines() == 0 && !cells[r][c].isMine()) {
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    revealCell(r + i, c + j);
                }
            }
        }
    }

    public boolean getIsBoardUpdated() {
        return this.isBoardUpdated;
    }

    public Cell getCell(int r, int c) {
        return this.cells[r][c];
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public boolean isMineAt(int r, int c) {
        return this.cells[r][c].isMine();
    }
}
