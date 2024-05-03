package Othello.Controller.Interface.Handlers;

import Othello.Model.Board;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import Othello.Model.Game;

public class CellClickHandler implements EventHandler {

    int row;
    int col;

    Game game;

    public CellClickHandler(int row, int col, Game game){
        this.row = row;
        this.col = col;
        this.game = game;
    }

    @Override
    public void handle(Event event) {
        game.makeMove(row, col, game.getCurrentPlayer());
    }
}
