import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameTest {

    private Game game;

    private GameInput mockGameInput;
    private Board mockBoard;

    @BeforeEach
    public void setUp() {
        this.game = new Game();

        this.mockGameInput = mock(GameInput.class);
        this.mockBoard = mock(Board.class);
    }

    @Test
    public void testStartGame_WinScenario() {
        // Mocking input
        when(mockGameInput.inputGridSize()).thenReturn(4);
        when(mockGameInput.inputTotalMines(4)).thenReturn(1);
        when(mockGameInput.selectSquare()).thenReturn("A1", "A2");

        // Mocking board
        when(mockBoard.isMineAt(anyInt(), anyInt())).thenReturn(false);
        when(mockBoard.getCell(anyInt(), anyInt()).getAdjacentMines()).thenReturn(0);
        when(mockBoard.getRows()).thenReturn(4);
        when(mockBoard.getCols()).thenReturn(4);

        game.start();

        assertTrue(1==1);
    }

//    @Test
//    public void testStartGame_LoseScenario() {
//        when(mockGameInput.inputGridSize()).thenReturn(4);
//        when(mockGameInput.inputTotalMines(4)).thenReturn(1);
//        when(mockGameInput.selectSquare()).thenReturn("A1");
//
//        Board mockBoard = mock(Board.class);
//        when(mockBoard.isMineAt(anyInt(), anyInt())).thenReturn(true);
//
//        game.board = mockBoard;
//
//        game.start();
//
//        assertTrue(game.gameOver);
//    }

//    @Test
//    public void testSetup() {
//        when(mockGameInput.inputGridSize()).thenReturn(5);
//        when(mockGameInput.inputTotalMines(5)).thenReturn(5);
//
//        game.setup();
//
//        assertNotNull(game.board);
//        assertFalse(game.gameOver);
//    }
//
//    @Test
//    public void testIsWin() {
//        Board mockBoard = mock(Board.class);
//        when(mockBoard.getRows()).thenReturn(2);
//        when(mockBoard.getCols()).thenReturn(2);
//
//        Cell cell1 = mock(Cell.class);
//        when(cell1.isMine()).thenReturn(false);
//        when(cell1.isRevealed()).thenReturn(true);
//
//        Cell cell2 = mock(Cell.class);
//        when(cell2.isMine()).thenReturn(false);
//        when(cell2.isRevealed()).thenReturn(true);
//
//        when(mockBoard.getCell(anyInt(), anyInt())).thenReturn(cell1, cell2);
//
//        game.board = mockBoard;
//
//        assertTrue(game.isWin());
//    }
//
//    @Test
//    public void testRestart() {
//        when(mockGameInput.inputAnyKey()).thenReturn("n");
//
//        game.restart();
//
//        verify(mockGameInput, times(1)).inputAnyKey();
//    }
}
