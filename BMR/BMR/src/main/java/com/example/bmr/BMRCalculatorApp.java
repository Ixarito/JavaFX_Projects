package com.example.bmr;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BMRCalculatorApp extends Application {

    //Menu
    private Menu menuFichier;
    //Menu elements
    private MenuItem clear;
    private MenuItem exit;
    //MenuBar
    private MenuBar menuBar;

    //Left Elements
    private Label tailleLabel;
    private TextField sizeTextField;
    private Label weightLabel;
    private TextField weightTextField;
    private Label ageLabel;
    private TextField ageTextField;
    private Label sexeLabel;
    private RadioButton womenRadioButton;
    private RadioButton menRadioButton;
    private ToggleGroup sexeToggleGroup;
    private Label lifeStyleLabel;
    private ChoiceBox<String> lifeStyleChoiceBox;

    //Right elements
    private Label bmrLabel;
    private TextField resultatTextField;
    private Label caloriesLabel;
    private TextField caloriesTextField;

    //footer Button
    private Button calculerBMRButton;

    //Containers
    private VBox myContainer;
    private VBox myVBox;
    private HBox myHBox;
    private GridPane myLeftGridPane;
    private GridPane myRightGridPane;
    //sexeToggle group
    private HBox mySexeToggleButtons;




    public static void main(String[] args) {
        launch(args);
    }

    /**
     * This method returns the lifeStyleIndex according to the user's choice.
     * @param lifeStyle the user's choice
     * @return the lifeStyleIndex
     */
    public static double lifeStyleIndex(String lifeStyle) {
        return switch (lifeStyle) {
            case "Sédentaire" -> 1.2;
            case "Peu actif" -> 1.375;
            case "Actif" -> 1.55;
            case "Fort actif" -> 1.725;
            case "Extrêmement actif" -> 1.9;
            default -> 0;
        };
    }

    /**
     * This method is called when the user clicks on the "Calculer BMR" button.
     */
    public void bmrButton(){
        String tailleStr = sizeTextField.getText();
        String poidsStr = weightTextField.getText();
        String ageStr = ageTextField.getText();
        Toggle sexeToggle = sexeToggleGroup.getSelectedToggle();
        String lifeStyle = lifeStyleChoiceBox.getValue();
        if (tailleStr.isEmpty() || poidsStr.isEmpty() || ageStr.isEmpty() || sexeToggle == null || lifeStyle == null) {
            System.err.println("missing values");
            resultatTextField.setStyle("-fx-text-fill: red;");
            caloriesTextField.setStyle("-fx-text-fill: red;");
            resultatTextField.setText("failed");
            caloriesTextField.setText("failed");
            return;
        }
        String sexe = (sexeToggle == womenRadioButton) ? "Femme" : "Homme";
        double taille, poids;
        int age;
        try {
            taille = Double.parseDouble(tailleStr);
            poids = Double.parseDouble(poidsStr);
            age = Integer.parseInt(ageStr);
        } catch (NumberFormatException e) {
            System.out.println("Veuillez entrer des nombres valides.");
            return;
        }
        if (taille == 0 || poids == 0 || age == 0) {
            showAlert();
            return;
        }
        double bmr = 0;
        switch (sexe) {
            case "Femme" -> bmr = 9.6 * poids + 1.8 * taille - 4.7 * age + 655;
            case "Homme" -> bmr = 13.7 * poids + 5 * taille - 6.8 * age + 66;
        }
        double calories = bmr * lifeStyleIndex(lifeStyle);
        bmr = Math.round(bmr * 10.0) / 10.0;
        resultatTextField.setStyle("-fx-text-fill: black;");
        caloriesTextField.setStyle("-fx-text-fill: black;");
        resultatTextField.setText(String.valueOf(bmr));
        caloriesTextField.setText(String.valueOf(calories));
    }

    /**
     * This method is called when the user clicks on the "Quitter" button.
     */
    public static void exit(){
        System.exit(0);
    }

    /**
     * This method is called when the user clicks on the "Effacer les champs" button.
     */
    public void clearTextFields(){
        ageTextField.clear();
        caloriesTextField.clear();
        sizeTextField.clear();
        resultatTextField.clear();
        weightTextField.clear();
        menRadioButton.setSelected(false);
        womenRadioButton.setSelected(false);
        lifeStyleChoiceBox.setValue(null);
    }

    /**
     * This method is called when the user enters a value equal to 0.
     */
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Attention !");
        alert.setHeaderText(null);
        alert.setContentText("Vous avez rentré une valeur égale à 0");

        alert.showAndWait();
    }

    /**
     * This method is called when the application is launched.
     * @param primaryStage the stage
     */
    @Override
    public void start(Stage primaryStage) {
    //Attributes initialisation
        menuFichier = new Menu("Menu");
        clear = new MenuItem("Effacer les champs");
        clear.setOnAction(actionEvent -> clearTextFields());
        exit = new MenuItem("Quitter");
        exit.setOnAction(actionEvent -> exit());
        menuBar = new MenuBar();
        tailleLabel = new Label("Taille (cm):");
        sizeTextField = new TextField();
        weightLabel = new Label("Poids (kg):");
        weightTextField = new TextField();
        ageLabel = new Label("Âge (années):");
        ageTextField = new TextField();
        sexeLabel = new Label("Sexe:");
        womenRadioButton = new RadioButton("Femme");
        sexeToggleGroup = new ToggleGroup();
        womenRadioButton.setToggleGroup(sexeToggleGroup);
        menRadioButton = new RadioButton("Homme");
        menRadioButton.setToggleGroup(sexeToggleGroup);
        lifeStyleLabel = new Label("Style de vie:");
        lifeStyleChoiceBox = new ChoiceBox<>();
        lifeStyleChoiceBox.getItems().addAll("Sédentaire", "Peu actif", "Actif", "Fort actif", "Extrêmement actif");
        bmrLabel = new Label("BMR:");
        resultatTextField = new TextField();
        resultatTextField.setEditable(false);
        caloriesLabel = new Label("Calories:");
        caloriesTextField = new TextField();
        caloriesTextField.setEditable(false);
        calculerBMRButton = new Button("Calcul du BMR");
        calculerBMRButton.setMaxWidth(Double.MAX_VALUE);
        calculerBMRButton.setOnAction(event -> bmrButton());
        myContainer = new VBox(10);
        myVBox = new VBox(10);
        myHBox = new HBox(10);
        myLeftGridPane = new GridPane();
        myRightGridPane = new GridPane();
        mySexeToggleButtons = new HBox(10);

        primaryStage.setTitle("Calculateur de BMR");



    // Adding elements to containers
        menuFichier.getItems().addAll(clear, exit);
        menuBar.getMenus().add(menuFichier);
        myContainer.getChildren().addAll(menuBar, myVBox);

        myVBox.getChildren().addAll(myHBox, calculerBMRButton);
        myHBox.getChildren().addAll(myLeftGridPane, myRightGridPane);
        myLeftGridPane.add(tailleLabel, 0, 0);
        myLeftGridPane.add(sizeTextField, 1, 0);
        myLeftGridPane.add(weightLabel, 0, 1);
        myLeftGridPane.add(weightTextField, 1, 1);
        myLeftGridPane.add(ageLabel, 0, 2);
        myLeftGridPane.add(ageTextField, 1, 2);
        myLeftGridPane.add(sexeLabel, 0, 3);

        mySexeToggleButtons.getChildren().addAll(womenRadioButton, menRadioButton);

        myLeftGridPane.add(mySexeToggleButtons, 1, 3);
        myLeftGridPane.add(lifeStyleLabel, 0, 4);
        myLeftGridPane.add(lifeStyleChoiceBox, 1, 4);
        myRightGridPane.add(bmrLabel, 0, 0);
        myRightGridPane.add(resultatTextField, 1, 0);
        myRightGridPane.add(caloriesLabel, 0, 1);
        myRightGridPane.add(caloriesTextField, 1, 1);
        myVBox.setPadding(new Insets(20, 20, 20, 20));


    //All Margins/paddings
        //add vertical space between nodes from myLeftGridPane
        myLeftGridPane.setVgap(10);
        //adding margin to myLeftGridPane
        for (Node node : myLeftGridPane.getChildren()) {
            GridPane.setMargin(node, new Insets(0, 20, 0, 20));
        }
        //add vertical space between nodes from myRightGridPane
        myRightGridPane.setVgap(10);
        //adding margin to myRightGridPane
        for (Node node : myRightGridPane.getChildren()) {
            GridPane.setMargin(node, new Insets(0, 20, 0, 20));
        }
        myVBox.setPadding(new Insets(20, 20, 20, 20));


    //Scene
        Scene scene = new Scene(myContainer, 650, 300);
        myContainer.setMinWidth(650);
        myContainer.setMinHeight(330);
        myVBox.setMinHeight(260);
        myVBox.setMaxWidth(Double.MAX_VALUE);
        myVBox.setMaxHeight(Double.MAX_VALUE);
        VBox.setVgrow(myHBox, Priority.ALWAYS);
        myHBox.setMaxWidth(Double.MAX_VALUE);
        myHBox.setMaxHeight(Double.MAX_VALUE);
        HBox.setHgrow(myLeftGridPane, Priority.ALWAYS);
        HBox.setHgrow(myRightGridPane, Priority.ALWAYS);
        primaryStage.setMinWidth(680);
        primaryStage.setMinHeight(340);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
