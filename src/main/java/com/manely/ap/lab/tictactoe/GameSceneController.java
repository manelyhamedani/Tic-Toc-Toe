package com.manely.ap.lab.tictactoe;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.NumberFormat;

import static java.lang.Thread.sleep;

public class GameSceneController {
    public static final int FIRST_BUTTON_INDEX = 10;
    public static final int LAST_BUTTON_INDEX = 18;
    private GameListener gameListener;
    private int remainingSec = 60;
    private final NumberFormat formatter = NumberFormat.getInstance();

    @FXML
    private GridPane gridPane;

    @FXML
    private Button exitButton;

    @FXML
    private Button musicButton;

    @FXML
    private Label timerLabel;

    @FXML
    private Label playerLabel;

    @FXML
    private Label statusLabel;

    public void initialize() {
        gameListener = new GameListener(gridPane.getChildren());

        timerLabel.setText("60");

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000),
                actionEvent -> {
                    --remainingSec;
                    timerLabel.setText(formatter.format(remainingSec));
                    if (remainingSec == 0) {
                        GameFactory.getInstance().finish();
                    }
                }));
        timeline.setCycleCount(60);
        timeline.play();

        gridPane.setStyle("-fx-background-color: #424141");
        exitButton.setStyle("-fx-background-color: #5b5858");
        musicButton.setStyle("-fx-background-color: #5b5858");

        int index = 0;
        for (Node child : gridPane.getChildren()) {
            child.setStyle("-fx-background-color: #424141");
            child.setUserData(index);
            ++index;
        }


        playerLabel.setText(GameFactory.getInstance().getPlayer() + ": X");
        statusLabel.setText("!your turn!");


        GameFactory.getInstance().getStatus().addListener((observableValue, oldValue, newValue) -> {
            if (!newValue) {
                timeline.stop();

                Stage stage = (Stage) gridPane.getScene().getWindow();

                Thread thread = new Thread(() -> {
                    try {
                        GameFactory.getInstance().finish();
                        Thread.sleep(2000);
                        Platform.runLater(() -> {
                            try {
                                SceneController.changeScene(stage, "win.fxml");
                            }
                            catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
                thread.start();
            }
        });
    }

    @FXML
    void exitButtonPressed(ActionEvent event) throws IOException {
        GameFactory.endGame();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        SceneController.changeScene(stage, "game-menu.fxml");
    }

    @FXML
    void musicButtonPressed() {
        MusicPlayer.changeStatus();
    }

    @FXML
    void buttonPressed(ActionEvent event) {
        ObservableList<Node> children = gridPane.getChildren();

        if (GameFactory.getInstance().getStatus().get()) {
            Button button = (Button) event.getSource();
            int index = (Integer) button.getUserData();

            if (!GameFactory.getInstance().isAvailable(index)) {
                return;
            }

            button.setTextFill(Color.PINK);
            button.setStyle("-fx-background-color: transparent");
            button.setText("X");
            GameFactory.getInstance().unavailableCell((Integer) button.getUserData());
            statusLabel.setText("!wait!");

            gameListener.onChanged();
        }

        if (GameFactory.getInstance().getStatus().get()) {
            int bIndex = GameFactory.getInstance().systemPlay();
            Button b = (Button) children.get(bIndex);
            b.setTextFill(Color.rgb(0x13, 0xaf, 0x13));
            b.setStyle("-fx-background-color: transparent");
            b.setText("O");

            gameListener.onChanged();

            statusLabel.setText("!your turn!");
        }
    }



}
