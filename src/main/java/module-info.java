module com.manely.ap.lab.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.manely.ap.lab.tictactoe to javafx.fxml;
    exports com.manely.ap.lab.tictactoe;
}