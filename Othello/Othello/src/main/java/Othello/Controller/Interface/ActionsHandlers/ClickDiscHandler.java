package Othello.Controller.Interface.ActionsHandlers;

import Othello.Model.Move;
import javafx.event.Event;
import javafx.event.EventHandler;
import Othello.Model.Game;

import java.util.ArrayList;

public class ClickDiscHandler implements EventHandler {

    int row;
    int col;

    Game game;

    public ClickDiscHandler(int row, int col, Game game){
        this.row = row;
        this.col = col;
        this.game = game;
    }

    @Override
    public void handle(Event event) {
        game.makeMove(row, col);
    }
}