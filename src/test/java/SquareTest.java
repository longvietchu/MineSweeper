import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareTest {
    private Square square;

    @BeforeEach
    public void setUp() {
        square = new Square();
    }

    @Test
    public void testInitialValues() {
        assertFalse(square.isMine());
        assertFalse(square.isRevealed());
        assertEquals(0, square.getAdjacentMines());
    }

    @Test
    public void testSetMine() {
        square.setMine(true);
        assertTrue(square.isMine());

        square.setMine(false);
        assertFalse(square.isMine());
    }

    @Test
    public void testReveal() {
        assertFalse(square.isRevealed());

        square.reveal();
        assertTrue(square.isRevealed());
    }

    @Test
    public void testSetAdjacentMines() {
        square.setAdjacentMines(3);
        assertEquals(3, square.getAdjacentMines());

        square.setAdjacentMines(5);
        assertEquals(5, square.getAdjacentMines());
    }
}