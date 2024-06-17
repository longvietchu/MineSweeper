public class Square {
    private boolean isMine;
    private boolean isRevealed;
    private int adjacentMines;

    public Square() {
        this.isMine = false;
        this.isRevealed = false;
        this.adjacentMines = 0;
    }

    /**
     * Checks if the square is a mine.
     *
     * @return true if the square is a mine, false otherwise.
     */
    public boolean isMine() {
        return this.isMine;
    }

    /**
     * Sets whether the square is a mine.
     *
     * @param isMine true to set the square as a mine, false to set it as not a mine.
     */
    public void setMine(boolean isMine) {
        this.isMine = isMine;
    }

    /**
     * Checks if the square has been revealed.
     *
     * @return true if the square has been revealed, false otherwise.
     */
    public boolean isRevealed() {
        return this.isRevealed;
    }

    /**
     * Reveals the square.
     */
    public void reveal() {
        this.isRevealed = true;
    }

    /**
     * Gets the number of adjacent mines.
     *
     * @return the number of adjacent mines.
     */
    public int getAdjacentMines() {
        return this.adjacentMines;
    }

    /**
     * Sets the number of adjacent mines.
     *
     * @param adjacentMines the number of adjacent mines.
     */
    public void setAdjacentMines(int adjacentMines) {
        this.adjacentMines = adjacentMines;
    }
}
