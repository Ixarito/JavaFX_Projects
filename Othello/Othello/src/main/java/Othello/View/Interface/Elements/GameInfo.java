package Othello.View.Interface.Elements;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import Othello.Model.Game;

public class GameInfo extends VBox implements OthelloObserver {

    private Game game;

    private Label currentPlayerLabel;
    private Label player1ScoreLabel;
    private Label player2ScoreLabel;

    public GameInfo(Game game){
        this.game = game;

        currentPlayerLabel = new Label();
        player1ScoreLabel = new Label();
        player2ScoreLabel = new Label();

        currentPlayerLabel.setText("Current player: " + game.getCurrentPlayer().getName());
        player1ScoreLabel.setText(game.getPlayer1().getName() + " score: " + game.getPlayer1().getScore());
        player2ScoreLabel.setText(game.getPlayer2().getName() + " score: " + game.getPlayer2().getScore());

        getChildren().addAll(currentPlayerLabel, player1ScoreLabel, player2ScoreLabel);

    }

    @Override
    public void update() {
        currentPlayerLabel.setText("Joueur courant: " + game.getCurrentPlayer().getName());
        player1ScoreLabel.setText(game.getPlayer1().getName() + " score: " + game.getPlayer1().getScore());
        player2ScoreLabel.setText(game.getPlayer2().getName() + " score: " + game.getPlayer2().getScore());
    }
}
