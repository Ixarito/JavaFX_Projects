package Othello.View.Interface.Elements;

import Othello.Model.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class EndGameMenu extends VBox {

    Label winnerLabbel;
    Button restartButton;
    Button quitButton;

    public EndGameMenu(Player winner) {
        String winnerText = (winner == null) ? "Match null" : "Le gagnant est : " + winner.getName();
        winnerLabbel = new Label(winnerText);
        winnerLabbel.setTextFill(Color.WHITE);
        winnerLabbel.setStyle("-fx-font-size: 50px;");

        restartButton = new Button("Rejouer");
        restartButton.setStyle("-fx-font-size: 20px;");

        quitButton = new Button("Quitter");
        quitButton.setStyle("-fx-font-size: 20px;");

        this.getChildren().addAll(winnerLabbel, restartButton, quitButton);
        this.setPadding(new Insets(10));
        this.setSpacing(40);
        this.setAlignment(Pos.CENTER);
    }

    public Button getRestartButton() {
        return restartButton;
    }

    public Button getQuitButton() {
        return quitButton;
    }
}
