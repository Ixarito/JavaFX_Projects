module com.example.othello {
    requires javafx.controls;
    requires javafx.fxml;

    exports Othello.Controller.Interface to javafx.graphics;
}