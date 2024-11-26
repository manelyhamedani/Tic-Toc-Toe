# Tic-Tac-Toe Game

## Overview

This is a simple implementation of the **Tic-Tac-Toe** game written in **Java** using **JavaFX** for the graphical user interface (GUI). The game is designed for **two players** and is played on a **3x3 grid**. Players alternate between placing "X" or "O" marks in an empty cell. The game features:
- A **user-friendly GUI** with buttons for each cell of the Tic-Tac-Toe grid.
- **Background music** to enhance the gaming experience.
- A **win condition** where the first player to align three marks horizontally, vertically, or diagonally wins the game.
- A **draw condition** where the game ends in a draw if the grid is full and no player wins.

The project is built with **JavaFX** for the GUI and **FXML** to separate the logic and the user interface design. The background music feature is implemented using **JavaFX MediaPlayer**.

### Features:
- **Two-player Mode**: Players can take turns marking the grid with either "X" or "O".
- **Graphical User Interface (GUI)**: An interactive UI built using **JavaFX** and **FXML** for clean design.
- **Background Music**: The game plays background music during gameplay, enhancing the experience.
- **Win Condition**: The game detects a winner if a player aligns three marks in a row, column, or diagonal.
- **Draw Condition**: If the grid is full and no one wins, the game ends in a draw.
- **Game Reset**: After a win or a draw, the game can be reset to start a new round.

## Requirements

Before running the Tic-Tac-Toe game, make sure you have the following installed:

- **Java 11+** (to compile and run the application).
- **JavaFX SDK** (for GUI components using FXML).
- **JavaFX MediaPlayer** (for playing background music).
- **IDE** (such as IntelliJ IDEA, Eclipse, or NetBeans) with JavaFX support.

## Compilation and Running the Game

### Steps to Run the Game:

1. **Clone or Download the Project**:
   Clone or download the repository to your local machine.

2. **Compile the Java Code**:
   If you are using an IDE like IntelliJ IDEA or Eclipse, the compilation should happen automatically. Otherwise, you can compile the Java code manually using the terminal.

3. **Run the Application**:
   To run the game, execute the `Driver.java` class, which contains the main method to launch the JavaFX application.
   
## License

This project is licensed under the MIT License - see the ![MIT License](https://img.shields.io/badge/license-MIT-blue.svg)
 file for details.
