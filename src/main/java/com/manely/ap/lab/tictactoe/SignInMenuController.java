package com.manely.ap.lab.tictactoe;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class SignInMenuController {

    @FXML
    private VBox root;

    @FXML
    private Button submitButton;

    @FXML
    private TextField usernameTextField;

    public void initialize() {
        Platform.runLater(() -> root.requestFocus());
        root.setStyle("-fx-background-color: #424141");
        submitButton.setStyle("-fx-background-color: #5b5858");
    }

    @FXML
    void submitButtonPressed(ActionEvent event) throws IOException {
        String username = usernameTextField.getText();
        if (username.isBlank()) {
            usernameTextField.setPromptText("Enter username");
        }
        else {
            GameFactory.getInstance().setPlayer(username);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            SceneController.changeScene(stage, "game-scene.fxml");
        }
    }

}
