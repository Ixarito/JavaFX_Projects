package Othello.Controller.Interface;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Othello.Model.Board;
import Othello.View.Interface.BoardView;
import Othello.Model.*;

public class main extends Application {

    private VBox myContainer;


    @Override
    public void start(Stage primaryStage) {
        int size = 8;
        Game game = new Game(new Player("Ixarito", Color.BLACK), new Player("Bot", Color.WHITE), size);

        // Register BoardView as an observer of Board
        myContainer = new VBox(10);


        BoardView boardView = new BoardView(game);

        Scene scene = new Scene(myContainer);
        myContainer.getChildren().add(boardView);
        game.registerObserver(boardView);
        game.notifyObservers();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}