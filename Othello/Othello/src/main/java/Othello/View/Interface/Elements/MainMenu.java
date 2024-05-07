package Othello.View.Interface.Elements;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainMenu extends VBox {
    private Label titleLabbel;
    private TextField nameInput;
    private ComboBox<String> difficultyChoice;
    private ComboBox<String> colorChoise;
    private TextField boardSizeInput;
    private Button startButton;

    public MainMenu() {
        titleLabbel = new Label("Bienvenue Dans Othello");
        titleLabbel.setTextFill(Color.WHITE);
        titleLabbel.setStyle("-fx-font-size: 60px;");

        nameInput = new TextField();
        nameInput.setPromptText("Entrez votre nom");
        nameInput.setStyle("-fx-font-size: 20px;");

        boardSizeInput = new TextField();
        boardSizeInput.setPromptText("Entrez la taille du plateau");
        boardSizeInput.setStyle("-fx-font-size: 20px;");

        colorChoise = new ComboBox<>();
        colorChoise.getItems().addAll("Blanc", "Noir");
        colorChoise.setPromptText("Choisissez votre couleur");
        colorChoise.setStyle("-fx-font-size: 20px;");

        difficultyChoice = new ComboBox<>();
        difficultyChoice.getItems().addAll("Facile", "Difficile");
        difficultyChoice.setPromptText("Choisissez la difficulté");
        difficultyChoice.setStyle("-fx-font-size: 20px;");

        startButton = new Button("Lancer la partie");
        startButton.setStyle("-fx-font-size: 20px;");

        this.getChildren().addAll(titleLabbel, nameInput, boardSizeInput, colorChoise, difficultyChoice, startButton);
        this.setSpacing(20);
        this.setAlignment(Pos.CENTER);
    }

    public TextField getNameInput() {
        return nameInput;
    }

    public TextField getBoardSizeInput() {
        return boardSizeInput;
    }

    public ComboBox<String> getColorChoise() {
        return colorChoise;
    }

    public ComboBox<String> getDifficultyChoice() {
        return difficultyChoice;
    }

    public Button getStartButton() {
        return startButton;
    }
}