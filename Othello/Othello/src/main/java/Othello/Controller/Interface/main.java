package Othello.Controller.Interface;

import Othello.View.Interface.GameInfo;
import Othello.View.Interface.MainMenu;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;
import Othello.Model.Board;
import Othello.View.Interface.BoardView;
import Othello.Model.*;

public class main extends Application {

    private BorderPane borderPane;
    private HBox myContainer;
    private VBox myContainer2;
    private HBox container;



    @Override
    public void start(Stage primaryStage) {

        int size = 8;
        Game game = new Game(new Player("Ixarito", Color.BLACK), new Player("Bot", Color.WHITE), size, true);

        // Register BoardView as an observer of Board
        borderPane = new BorderPane();
        myContainer = new HBox(10);
        myContainer2 = new VBox(10);
        container = new HBox(10);


        BoardView boardView = new BoardView(game);
        GameInfo gameInfo = new GameInfo(game);
        MainMenu mainMenu = new MainMenu();

        Scene scene = new Scene(myContainer);
        myContainer.getChildren().add(borderPane);
        myContainer.setAlignment(Pos.CENTER);
        borderPane.setCenter(myContainer2);
        myContainer2.getChildren().add(boardView);
        borderPane.setTop(gameInfo);



        game.registerObserver(boardView);
        game.registerObserver(gameInfo);
        game.notifyObservers();
        primaryStage.setScene(scene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        primaryStage.show();



        //margins - paddings
        gameInfo.setPadding(new Insets(5, 10, 5, 10));

    }

    public static void main(String[] args) {
        launch(args);
    }
}