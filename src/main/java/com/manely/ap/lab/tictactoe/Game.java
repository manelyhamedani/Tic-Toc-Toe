package com.manely.ap.lab.tictactoe;


import javafx.beans.property.SimpleBooleanProperty;

import java.util.ArrayList;
import java.util.Random;

public class Game {

    private final Random random = new Random();
    private String player;
    private final ArrayList<Integer> availableCellsIndexes = new ArrayList<>();
    private final SimpleBooleanProperty status = new SimpleBooleanProperty(true);
    private String winner;

    public Game() {
        for (int i = GameSceneController.FIRST_BUTTON_INDEX; i <= GameSceneController.LAST_BUTTON_INDEX; ++i) {
            availableCellsIndexes.add(i);
        }
    }

    public boolean isAvailable(Integer index) {
        return availableCellsIndexes.contains(index);
    }

    public int systemPlay() {
        int index = random.nextInt(availableCellsIndexes.size());
        Integer cellIndex = availableCellsIndexes.get(index);
        unavailableCell(cellIndex);
        return cellIndex;
    }

    public SimpleBooleanProperty getStatus() {
        return status;
    }

    public void setPlayer(String username) {
        player = username;
    }

    public String getPlayer() {
        return player;
    }

    public void unavailableCell(Integer index) {
        availableCellsIndexes.remove(index);
        if (availableCellsIndexes.size() == 0) {
            finish();
        }
    }

    public void finish() {
        status.set(false);
    }

    public void endGame(String winner) {
        this.winner = winner;
        finish();
    }

    public String getWinner() {
        return winner;
    }

}
