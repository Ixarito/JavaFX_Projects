package Othello.Controller.Commands;

import Othello.Model.Game;

public class MoveCommand implements Command {
    private Game game;
    private int row;
    private int col;

    public MoveCommand(Game game, int row, int col) {
        this.game = game;
        this.row = row;
        this.col = col;
    }

    @Override
    public void execute() {
        game.makeMove(row, col);
    }

    @Override
    public void unexecute() {
        game.undoMove();
    }
}