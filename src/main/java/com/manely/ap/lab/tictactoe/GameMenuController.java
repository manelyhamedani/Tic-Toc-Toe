package com.manely.ap.lab.tictactoe;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Paths;

public class GameMenuController {

    @FXML
    private VBox root;

    @FXML
    private Button exitButton;

    @FXML
    private Button playButton;

    @FXML
    private Button musicButton;

    public void initialize() {
        root.setStyle("-fx-background-color: #424141");
        exitButton.setStyle("-fx-background-color: #5b5858");
        playButton.setStyle("-fx-background-color: #5b5858");
        musicButton.setStyle("-fx-background-color: #5b5858");
    }

    @FXML
    void exitButtonPressed() {
        System.exit(0);
    }

    @FXML
    void playButtonPressed(ActionEvent event) throws IOException {
        GameFactory.newGame();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneController.changeScene(stage, "signIn-menu.fxml");
    }

    @FXML
    void musicButtonPressed() {
       MusicPlayer.changeStatus();
    }

}
