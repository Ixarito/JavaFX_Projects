package Othello.View.Interface.Elements;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class MainMenu extends VBox {
    private TextField nameInput;
    private ComboBox<String> difficultyChoice;
    private ComboBox<String> colorChoise;
    private TextField boardSizeInput;
    private Button startButton;

    public MainMenu() {
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

        this.getChildren().addAll(nameInput, boardSizeInput, colorChoise, difficultyChoice, startButton);
        this.setPadding(new Insets(10));
        this.setSpacing(8);
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