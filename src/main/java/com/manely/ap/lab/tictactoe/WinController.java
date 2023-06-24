package com.manely.ap.lab.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class WinController {

    @FXML
    private VBox root;

    @FXML
    private Button menuButton;

    @FXML
    private Button replayButton;

    @FXML
    private Label resultLabel;

    public void initialize() {
        root.setStyle("-fx-background-color: #424141");
        menuButton.setStyle("-fx-background-color: #5b5858");
        replayButton.setStyle("-fx-background-color: #5b5858");
        resultLabel.setStyle("-fx-background-color: #424141");

        String winner = GameFactory.getInstance().getWinner();

        if (winner == null) {
            resultLabel.setText("DRAW!");
        }
        else {
            resultLabel.setText(GameFactory.getInstance().getWinner() + " WON!");
        }
    }

    @FXML
    void menuButtonPressed(ActionEvent event) throws IOException {
        GameFactory.endGame();

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneController.changeScene(stage, "game-menu.fxml");
    }

    @FXML
    void replayButtonPressed(ActionEvent event) throws IOException {
        String lastUsername = GameFactory.getInstance().getPlayer();

        GameFactory.newGame();
        GameFactory.getInstance().setPlayer(lastUsername);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneController.changeScene(stage, "game-scene.fxml");
    }

}
