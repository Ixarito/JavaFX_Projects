package Othello.Controller.Interface;

import Othello.View.Interface.GameInfo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import Othello.Model.Board;
import Othello.View.Interface.BoardView;
import Othello.Model.*;

public class main extends Application {

    private BorderPane borderPane;
    private HBox myContainer;



    @Override
    public void start(Stage primaryStage) {
        int size = 8;
        Game game = new Game(new Player("Ixarito", Color.BLACK), new Player("Bot", Color.WHITE), size, true);

        // Register BoardView as an observer of Board
        borderPane = new BorderPane();
        myContainer = new HBox(10);


        BoardView boardView = new BoardView(game);
        GameInfo gameInfo = new GameInfo(game);

        Scene scene = new Scene(myContainer);
        myContainer.getChildren().add(borderPane);
        borderPane.setCenter(boardView);
        borderPane.setRight(gameInfo);


        game.registerObserver(boardView);
        game.registerObserver(gameInfo);
        game.notifyObservers();
        primaryStage.setScene(scene);
        primaryStage.show();



        //margins - paddings
        gameInfo.setPadding(new Insets(5, 10, 5, 10));

    }

    public static void main(String[] args) {
        launch(args);
    }
}