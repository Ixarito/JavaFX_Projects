package Othello.Controller.Interface;

import javafx.application.Application;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

public class main extends Application {


    @Override
    public void start(Stage primaryStage) {

        GameController gameController = new GameController(primaryStage);

        primaryStage.setTitle("Othello");
//        primaryStage.setFullScreen(true);
//        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}