package com.manely.ap.lab.tictactoe;

public class GameFactory {
    private static Game game;

    private GameFactory() {

    }

    public static void newGame() {
        game = new Game();
    }

    public static Game getInstance() {
        return game;
    }

    public static void endGame() {
        if (game != null)
            game = null;
    }

}
