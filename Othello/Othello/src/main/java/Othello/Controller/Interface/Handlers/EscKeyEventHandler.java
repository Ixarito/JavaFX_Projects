package Othello.Controller.Interface.Handlers;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class EscKeyEventHandler implements EventHandler<KeyEvent> {
    private Stage primaryStage;
    private Scene gameScene;
    private Scene gameMenuScene;
    private Scene currentScene;

    public EscKeyEventHandler(Stage primaryStage, Scene gameScene, Scene gameMenuScene, Scene currentScene) {
        this.primaryStage = primaryStage;
        this.gameScene = gameScene;
        this.gameMenuScene = gameMenuScene;
        this.currentScene = currentScene;
    }

    @Override
    public void handle(KeyEvent ke) {
        if (ke.getCode() == KeyCode.ESCAPE) {
            switchScene();
        }
    }

    private void switchScene() {
        if (currentScene == gameScene) {
            currentScene = gameMenuScene;
        } else {
            currentScene = gameScene;
        }
        primaryStage.setScene(currentScene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    }
}