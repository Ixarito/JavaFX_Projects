package Othello.View.Interface.Elements;

import Othello.Controller.Interface.Handlers.SkipButtonHandler;
import Othello.Model.Game;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class GameButtons extends HBox {

    private Button startButton;
    private Button undoButton;
    private Button redoButton;

    public GameButtons(Game game) {
        startButton = new Button("Passer le tour");
        startButton.setStyle("-fx-font-size: 20px;");

        undoButton = new Button("Undo");
        undoButton.setStyle("-fx-font-size: 20px;");

        redoButton = new Button("Redo");
        redoButton.setStyle("-fx-font-size: 20px;");

        this.getChildren().addAll(startButton, undoButton, redoButton);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
    }


    public Button getStartButton() {
        return startButton;
    }

    public Button getUndoButton() {
        return undoButton;
    }

    public Button getRedoButton() {
        return redoButton;
    }
}
