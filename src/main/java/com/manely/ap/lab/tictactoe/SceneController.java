package com.manely.ap.lab.tictactoe;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneController {
    private SceneController() {

    }

    public static void changeScene(Stage stage, String path) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneController.class.getResource(path));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setScene(scene);
        stage.show();
    }

}