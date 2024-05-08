package Othello.View.Interface.Elements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameMenu extends VBox {

    Label winnerLabbel;
    Button giveUpButton;
    Button quitButton;

    public GameMenu() {
        winnerLabbel = new Label("Partie en pause");
        winnerLabbel.setTextFill(Color.WHITE);
        winnerLabbel.setStyle("-fx-font-size: 20px;");

        giveUpButton = new Button("Arrêter la partie");
        giveUpButton.setStyle("-fx-font-size: 20px;");

        quitButton = new Button("Quitter");
        quitButton.setStyle("-fx-font-size: 20px;");

        this.getChildren().addAll(winnerLabbel, giveUpButton, quitButton);
        this.setPadding(new Insets(10));
        this.setSpacing(40);
        this.setAlignment(Pos.CENTER);
    }

    public Button getGiveUpButton() {
        return giveUpButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }
}
