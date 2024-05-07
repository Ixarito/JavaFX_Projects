package Othello.Controller.Interface.Handlers;

import Othello.Model.Game;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class UnhoverDiscHandler implements EventHandler<MouseEvent> {

    private int row;
    private int col;
    private Game game;
    private Circle disc;

    public UnhoverDiscHandler(int row, int col, Game game, Circle disc){
        this.row = row;
        this.col = col;
        this.game = game;
        this.disc = disc;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        if (game.getBoardGrid()[row][col] == null){
            disc.setFill(Color.TRANSPARENT);
        }
    }
}
