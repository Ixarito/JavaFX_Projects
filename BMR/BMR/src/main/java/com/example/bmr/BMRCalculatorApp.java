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

    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Calculateur de BMR");



        //Left Elements
        Label tailleLabel = new Label("Taille (cm):");
        TextField tailleTextField = new TextField();

        Label poidsLabel = new Label("Poids (kg):");
        TextField poidsTextField = new TextField();

        Label ageLabel = new Label("Âge (années):");
        TextField ageTextField = new TextField();

        Label sexeLabel = new Label("Sexe:");
        RadioButton femmeRadioButton = new RadioButton("Femme");
        RadioButton hommeRadioButton = new RadioButton("Homme");
        ToggleGroup sexeToggleGroup = new ToggleGroup();
        femmeRadioButton.setToggleGroup(sexeToggleGroup);
        hommeRadioButton.setToggleGroup(sexeToggleGroup);

        Label styleDeVieLabel = new Label("Style de vie:");
        ChoiceBox<String> styleDeVieChoiceBox = new ChoiceBox<>();
        styleDeVieChoiceBox.getItems().addAll("Sédentaire", "Peu actif", "Actif", "Fort actif", "Extrêmement actif");



        Button calculerBMRButton = new Button("Calcul du BMR");
        calculerBMRButton.setMaxWidth(Double.MAX_VALUE); // Ajoutez cette ligne

        //Right elements
        Label bmrLabel = new Label("BMR:");
        TextField resultatTextField = new TextField();
        resultatTextField.setEditable(false);

        Label caloriesLabel = new Label("Calories:");
        TextField caloriesTextField = new TextField();
        caloriesTextField.setEditable(false);


        // Création des conteneurs
        VBox myVBox = new VBox(10);
        GridPane myMainGridPane = new GridPane();
        HBox myHBox = new HBox(10);
        GridPane myLeftGridPane = new GridPane();
        GridPane myRightGridPane = new GridPane();
        //sexeToggle group
        HBox mySexeToggleButtons = new HBox(10);






        // Adding elements to containers
        myVBox.getChildren().addAll(myHBox, calculerBMRButton);
        myHBox.getChildren().addAll(myLeftGridPane, myRightGridPane);
        myLeftGridPane.add(tailleLabel, 0, 0);
        myLeftGridPane.add(tailleTextField, 1, 0);
        myLeftGridPane.add(poidsLabel, 0, 1);
        myLeftGridPane.add(poidsTextField, 1, 1);
        myLeftGridPane.add(ageLabel, 0, 2);
        myLeftGridPane.add(ageTextField, 1, 2);
        myLeftGridPane.add(sexeLabel, 0, 3);
        mySexeToggleButtons.getChildren().addAll(femmeRadioButton, hommeRadioButton);
        myLeftGridPane.add(mySexeToggleButtons, 1, 3);
        myLeftGridPane.add(styleDeVieLabel, 0, 4);
        myLeftGridPane.add(styleDeVieChoiceBox, 1, 4);

        myRightGridPane.add(bmrLabel, 0, 0);
        myRightGridPane.add(resultatTextField, 1, 0);
        myRightGridPane.add(caloriesLabel, 0, 1);
        myRightGridPane.add(caloriesTextField, 1, 1);




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




        GridPane rightGridPane = new GridPane();
        rightGridPane.setVgap(10);



        // Scene
        Scene scene = new Scene(myVBox, 650, 300);

        myVBox.setMinWidth(650);
        myVBox.setMinHeight(300);
        myVBox.setMaxWidth(Double.MAX_VALUE);
        myVBox.setMaxHeight(Double.MAX_VALUE);

        VBox.setVgrow(myHBox, Priority.ALWAYS);
        myVBox.setPadding(new Insets(20, 20, 20, 20));
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
