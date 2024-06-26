import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InputHandlerTest {

    @BeforeEach
    public void setUp() {
        System.setIn(System.in);
    }

    @Test
    public void testInputGridSize_ValidInput() {
        String input = "4\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int gridSize = inputHandler.inputGridSize();
        assertEquals(4, gridSize);
    }

    @Test
    public void testInputGridSize_InputLessThanMinimum() {
        String input = "2\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int gridSize = inputHandler.inputGridSize();
        assertEquals(5, gridSize);
    }

    @Test
    public void testInputGridSize_InputGreaterThanMaximum() {
        String input = "11\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int gridSize = inputHandler.inputGridSize();
        assertEquals(5, gridSize);
    }

    @Test
    public void testInputGridSize_InputIsNotAnInteger() {
        String input = "A\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int gridSize = inputHandler.inputGridSize();
        assertEquals(5, gridSize);
    }

    @Test
    public void testInputTotalMines_ValidInput() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int totalMines = inputHandler.inputTotalMines(4); // Assuming a 4x4 grid
        assertEquals(3, totalMines);
    }

    @Test
    public void testInputTotalMines_InputLessThanMinimum() {
        String input = "0\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int totalMines = inputHandler.inputTotalMines(4); // Assuming a 4x4 grid
        assertEquals(3, totalMines);
    }

    @Test
    public void testInputTotalMines_InputLessThanMaximum() {
        String input = "6\n3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int totalMines = inputHandler.inputTotalMines(4); // Assuming a 4x4 grid
        assertEquals(3, totalMines);
    }

    @Test
    public void testInputTotalMines_InputIsNotAnInteger() {
        String input = "A\n5\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int gridSize = inputHandler.inputTotalMines(4);
        assertEquals(5, gridSize);
    }

    @Test
    public void testSelectSquare_ValidInput() {
        String input = "A1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int[] square = inputHandler.selectSquare(4);
        int[] expectedSquare = {0, 0};
        assertArrayEquals(expectedSquare, square);
    }

    @Test
    public void testSelectSquare_InputLengthGreaterThanTwo() {
        String input = "AAA\nA1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int[] square = inputHandler.selectSquare(4);
        int[] expectedSquare = {0, 0};
        assertArrayEquals(expectedSquare, square);
    }

    @Test
    public void testSelectSquare_InputFirstCharIsNotAlphabetic() {
        String input = "@1\nB1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int[] square = inputHandler.selectSquare(4);
        int[] expectedSquare = {1, 0};
        assertArrayEquals(expectedSquare, square);
    }

    @Test
    public void testSelectSquare_InputSecondCharIsNotDigit() {
        String input = "CC\nC2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int[] square = inputHandler.selectSquare(4);
        int[] expectedSquare = {2, 1};
        assertArrayEquals(expectedSquare, square);
    }

    @Test
    public void testSelectSquare_InputRowGreaterThanGridSize() {
        String input = "E1\nD1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int[] square = inputHandler.selectSquare(4);
        int[] expectedSquare = {3, 0};
        assertArrayEquals(expectedSquare, square);
    }

    @Test
    public void testSelectSquare_InputColGreaterThanGridSize() {
        String input = "C6\nC2\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        int[] square = inputHandler.selectSquare(4);
        int[] expectedSquare = {2, 1};
        assertArrayEquals(expectedSquare, square);
    }

    @Test
    public void testInputAnyKey_ValidInput() {
        String input = "y\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        String response = inputHandler.inputRestartGame();
        assertEquals("y", response);
    }

    @Test
    public void testInputAnyKey_InvalidInput() {
        String input = "xyz\nn\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        InputHandler inputHandler = new InputHandler();
        String response = inputHandler.inputRestartGame();
        assertEquals("n", response);
    }
}