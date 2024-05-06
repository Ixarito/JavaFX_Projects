package Othello.View.Interface.Elements;

import Othello.Controller.Interface.ActionsHandlers.SkipButtonHandler;
import Othello.Model.Game;
import Othello.View.Interface.Scene.GameScene;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class GameButtons extends HBox {

    private Button startButton;

    public GameButtons(Game game) {
        startButton = new Button("Passer le tour");
        startButton.setStyle("-fx-font-size: 20px;");
        this.getChildren().addAll(startButton);
        startButton.setOnAction(new SkipButtonHandler(game));
        this.setAlignment(Pos.CENTER);
    }

}
