package Othello.Controller.Interface;

import Othello.Controller.Interface.ActionsHandlers.EscKeyEventHandler;
import Othello.Model.*;
import Othello.View.Interface.Elements.*;
import Othello.View.Interface.Scene.EndGameScene;
import Othello.View.Interface.Scene.GameMenuScene;
import Othello.View.Interface.Scene.GameScene;
import Othello.View.Interface.Scene.MainMenuScene;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;


public class GameController implements ControllerObserver {
    private Game game;
    private MainMenu mainMenu;
    private BoardView boardView;
    private GameInfo gameInfo;
    private GameMenu gameMenu;
    private GameButtons gameButtons;
    private EndGameMenu endGameMenu;
    private Stage primaryStage;
    private Scene mainMenuScene;
    private Scene endGameScene;
    private Scene gameScene;
    private Scene gameMenuScene;
    private Scene currentScene;

    EscKeyEventHandler escKeyEventHandler;


    public GameController(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.mainMenu = new MainMenu();
        this.mainMenuScene = new MainMenuScene(mainMenu);
        this.primaryStage.setScene(mainMenuScene);

        mainMenu.getStartButton().setOnAction(actionEvent -> startGame());
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

    public void startGame() {

        //player's name
        String name = mainMenu.getNameInput().getText();
        if (name.equals("")){
           return;
        }

        //player's color
        String colorName = mainMenu.getColorChoise().getValue();
        Color p1Color;
        Color p2Color;
        if (colorName == null) {
            return;
        } else if (colorName.equals("Noir")){
            p1Color = Color.BLACK;
            p2Color = Color.WHITE;
        } else {
            p1Color = Color.WHITE;
            p2Color = Color.BLACK;
        }

        //board size
        int size;
        try {
            size = Integer.parseInt(mainMenu.getBoardSizeInput().getText());
            if (size > 15 || size < 4){
                return;
            }

        } catch (Exception e){
            return;
        }

        //difficulty
        String difficultyName = mainMenu.getDifficultyChoice().getValue();
        AiStrategy aiStrategy;
        if (difficultyName == null) {
            return;
        } else if (difficultyName.equals("Facile")){
            aiStrategy = new EasyAi();
        } else {
            aiStrategy = new HardAi();
        }

        //creation of players
        Player player1 = new Player(name, p1Color);
        Player player2 = new Player("Bot", p2Color);

        //gameCreation
        game = new Game(player1, player2, size, aiStrategy);

        boardView = new BoardView(game);
        gameInfo = new GameInfo(game);
        gameMenu = new GameMenu();
        gameButtons = new GameButtons(game);
        gameScene = new GameScene(gameInfo, boardView, gameButtons);
        gameMenuScene = new GameMenuScene(gameMenu);

        escKeyEventHandler = new EscKeyEventHandler(primaryStage, gameScene, gameMenuScene, currentScene);
        gameScene.addEventFilter(KeyEvent.KEY_PRESSED, escKeyEventHandler);
        gameMenuScene.addEventFilter(KeyEvent.KEY_PRESSED, escKeyEventHandler);
        game.registerObserver(boardView);
        game.registerObserver(gameInfo);
        game.registerEndGameObserver(this);
        game.notifyObservers();


        primaryStage.setScene(gameScene);

        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

    }

    private void backToMenu(){
        primaryStage.setScene(mainMenuScene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
    }

    @Override
    public void update(Player player) {
        endGameMenu = new EndGameMenu(player);
        endGameMenu.getQuitButton().setOnAction(actionEvent -> System.exit(0));
        endGameMenu.getRestartButton().setOnAction(actionEvent ->backToMenu());

        endGameScene = new EndGameScene(endGameMenu);

        primaryStage.setScene(endGameScene);
        primaryStage.setFullScreen(true);
        primaryStage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);

    }
}
