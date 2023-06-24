package com.manely.ap.lab.tictactoe;

import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Button;

public class GameListener {
    private final ObservableList<Node> list;
    private final int first = GameSceneController.FIRST_BUTTON_INDEX;
    private final int[][] patterns = {{first, first + 1, first + 2},
                                        {first + 3, first + 4, first + 5},
                                        {first + 6, first + 7, first + 8},
                                        {first, first + 3, first + 6},
                                        {first + 1, first + 4, first + 7},
                                        {first + 2, first + 5, first + 8},
                                        {first, first + 4, first + 8},
                                        {first + 2, first + 4, first + 6}};


    public GameListener(ObservableList list) {
        this.list = list;
    }

    public void onChanged() {
        for (int[] pattern : patterns) {
            Button b1 = (Button) list.get(pattern[0]);
            Button b2 = (Button) list.get(pattern[1]);
            Button b3 = (Button) list.get(pattern[2]);

            String b1text = b1.getText();
            String b2text = b2.getText();
            String b3text = b3.getText();

            if (b1text.isBlank() || b2text.isBlank() || b3text.isBlank()) {
                continue;
            }

            if (b1.getText().equals(b2.getText()) && b2.getText().equals(b3.getText())) {
                GameFactory.getInstance().endGame(b1.getText());
                return;
            }
        }

    }
}
