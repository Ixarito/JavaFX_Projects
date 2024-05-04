package Othello.Controller.Interface.Handlers;

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
        game.makeMove(row, col, game.getCurrentPlayer());
        if (game.isSoloMode()){
            //Ai's turn
            ArrayList<Move> moves = game.getValidMoves(game.getCurrentPlayer());
            if (moves.isEmpty()) {
                game.switchPlayer();
                return;
            }
            int moveIndex = (int) (Math.random() * moves.size());
            game.makeMove(moves.get(moveIndex).getRow(), moves.get(moveIndex).getCol(), game.getCurrentPlayer());
        }
    }
}
