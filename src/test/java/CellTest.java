import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    private Cell cell;

    @BeforeEach
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void testInitialValues() {
        assertFalse(cell.isMine());
        assertFalse(cell.isRevealed());
        assertEquals(0, cell.getAdjacentMines());
    }

    @Test
    public void testSetMine() {
        cell.setMine(true);
        assertTrue(cell.isMine());

        cell.setMine(false);
        assertFalse(cell.isMine());
    }

    @Test
    public void testReveal() {
        assertFalse(cell.isRevealed());

        cell.reveal();
        assertTrue(cell.isRevealed());
    }

    @Test
    public void testSetAdjacentMines() {
        cell.setAdjacentMines(3);
        assertEquals(3, cell.getAdjacentMines());

        cell.setAdjacentMines(5);
        assertEquals(5, cell.getAdjacentMines());
    }
}