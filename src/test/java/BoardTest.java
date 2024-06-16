import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private Board board;

    @BeforeEach
    void setUp() {
        this.board = new Board(5, 5, 5);
    }

    @Test
    void testBoardInitialization() {
        assertNotNull(this.board);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertNotNull(this.board.getCell(i, j));
            }
        }
    }

    @Test
    public void testRevealCell() {
        this.board.revealCell(0, 0);
        assertTrue(this.board.getCell(0, 0).isRevealed());
    }

    @Test
    void testIsBoardUpdated() {
        boolean result = this.board.getIsBoardUpdated();
        assertFalse(result);
    }

    @Test
    void testGetCell() {
        Cell cell = this.board.getCell(2, 3);
        assertNotNull(cell);
    }

    @Test
    void testGetRows() {
        int rows = this.board.getRows();
        assertEquals(5, rows);
    }

    @Test
    void testGetCols() {
        int cols = this.board.getCols();
        assertEquals(5, cols);
    }

    @Test
    void testIsMineAt() {
        boolean isMineAtResult = this.board.isMineAt(0, 0);
        assertEquals(this.board.getCell(0, 0).isMine(), isMineAtResult);
    }
}