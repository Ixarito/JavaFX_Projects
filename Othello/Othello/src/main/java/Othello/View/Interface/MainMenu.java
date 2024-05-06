package Othello.View.Interface;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox {

    public MainMenu() {
        TextField nameInput = new TextField();
        nameInput.setPromptText("Entrez votre nom");
        nameInput.setStyle("-fx-font-size: 20px;");

        ComboBox<String> difficultyChoice = new ComboBox<>();
        difficultyChoice.getItems().addAll("Facile", "Difficile");
        difficultyChoice.setPromptText("Choisissez la difficulté");
        difficultyChoice.setStyle("-fx-font-size: 20px;");

        TextField boardSizeInput = new TextField();
        boardSizeInput.setPromptText("Entrez la taille du plateau");
        boardSizeInput.setStyle("-fx-font-size: 20px;");

        Button startButton = new Button("Lancer la partie");
        startButton.setStyle("-fx-font-size: 20px;");

        this.getChildren().addAll(nameInput, difficultyChoice, boardSizeInput, startButton);
        this.setPadding(new Insets(10));
        this.setSpacing(8);
    }
}