package Othello.View.Interface.Elements;


import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import Othello.Model.Game;
import javafx.scene.paint.Color;

public class GameInfo extends HBox implements ViewObserver {

    private Game game;

//    private Label currentPlayerLabel;
    private Label player1ScoreLabel;
    private Label player2ScoreLabel;

    public GameInfo(Game game){
        this.game = game;

//        currentPlayerLabel = new Label();
        player1ScoreLabel = new Label();
        player2ScoreLabel = new Label();

//        currentPlayerLabel.setStyle("-fx-font-size: 25px;");
        player1ScoreLabel.setStyle("-fx-font-size: 25px;");
        player2ScoreLabel.setStyle("-fx-font-size: 25px;");

//        currentPlayerLabel.setTextFill(Color.WHITE);
        player1ScoreLabel.setTextFill(Color.WHITE);
        player2ScoreLabel.setTextFill(Color.WHITE);

//      finally the current player is useless in the game beacuse of the ai system
//        currentPlayerLabel.setText("Current player : " + game.getCurrentPlayer().getName());
        player1ScoreLabel.setText(game.getPlayer1().getName() + " score : " + game.getPlayer1().getScore());
        player2ScoreLabel.setText(game.getPlayer2().getName() + " score : " + game.getPlayer2().getScore());

        getChildren().addAll(player1ScoreLabel, player2ScoreLabel);

        this.setAlignment(Pos.CENTER);
        this.setSpacing(50);

    }

    @Override
    public void update() {
//        currentPlayerLabel.setText("Joueur courant : " + game.getCurrentPlayer().getName());
        player1ScoreLabel.setText(game.getPlayer1().getName() + " score : " + game.getPlayer1().getScore());
        player2ScoreLabel.setText(game.getPlayer2().getName() + " score : " + game.getPlayer2().getScore());
    }
}
