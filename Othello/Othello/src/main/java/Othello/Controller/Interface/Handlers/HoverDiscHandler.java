package Othello.Controller.Interface.Handlers;

import Othello.Model.Game;
import javafx.animation.FadeTransition;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class HoverDiscHandler implements EventHandler<MouseEvent> {

    private int row;
    private int col;
    private Game game;
    private Circle disc;

    private FadeTransition fadeTransition;


    public HoverDiscHandler(int row, int col, Game game, Circle disc){
        this.row = row;
        this.col = col;
        this.game = game;
        this.disc = disc;
        fadeTransition = new FadeTransition(Duration.seconds(0.2), disc);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
    }



    @Override
    public void handle(MouseEvent mouseEvent) {
        if (game.getBoardGrid()[row][col] == null){
            fadeTransition.play();
            if (game.isValidMove(row, col)){
                if (game.getCurrentPlayer().getColor().equals(Othello.Model.Color.WHITE)){
                    disc.setFill(Color.rgb(255,255,255,0.4));
                } else {
                    disc.setFill(Color.rgb(0,0,0,0.4));
                }
            } else {
                disc.setFill(Color.rgb(255,0,0,0.4));
            }
        }
    }
}
