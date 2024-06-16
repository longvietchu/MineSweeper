# MineSweeper CLI Game

---

## Overview

Welcome to the Minesweeper CLI Game! This project is a console-based implementation of the classic Minesweeper game, built with Java. The game allows you to play a grid of mines, trying to avoid detonating any mines while uncovering all the safe squares.

## Features

- **Custom Grid Size**: Choose the size of the grid (between 3x3 and 10x10).
- **Mines Placement**: Place a specified number of mines on the grid, up to 35% of the total squares.
- **Interactive Gameplay**: Select squares to reveal and see the number of adjacent mines.
- **Game Over and Win Conditions**: The game ends when a mine is detonated or all safe squares are revealed.

## Getting Started

### Prerequisites

- **Java 8 or higher**

### Installation

1. **Clone the Repository**:

   ```bash
   cd MineSweeper
   ```

2. **Compile the Code**:

   ```bash
   javac -d bin src/*.java
   ```

3. **Run the Game**:

   ```bash
   java -cp bin Game
   ```

## Usage

1. **Start the Game**: The game will prompt you to enter the grid size (e.g., 4 for a 4x4 grid) and the number of mines.
2. **Gameplay**:
   - Enter the square you want to reveal in the format `A1`.
   - The game will show the number of adjacent mines for each revealed square.
   - The game ends if you hit a mine or reveal all safe squares.

3. **Play Again**: After the game ends, you will be asked if you want to play again.

## Testing

### Running Tests

The project uses JUnit 5 and Mockito for unit testing. To run the tests, ensure you have the necessary dependencies installed, then execute:

```bash
mvn test
```

## Project Structure

- **`src/main/java`**: Contains the main code for the game.
   - `Main.java`: Entry point of the project to init and run the game.
   - `Game.java`: Main game logic.
   - `Board.java`: Manages the game board and cells.
   - `Cell.java`: Represents each cell on the board.
   - `GameInput.java`: Handles user input.

- **`src/test/java`**: Contains unit tests.
   - `BoardTest.java`: Tests for the Board class.
   - `CellTest.java`: Tests for the Cell class.
   - `GameInputTest.java`: Tests for the GameInput class.

## Acknowledgements

- **JUnit 5**: For testing framework.
- **Mockito**: For mocking dependencies in tests.