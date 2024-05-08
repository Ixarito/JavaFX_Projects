package Othello.Controller.Interface.Handlers;

import javafx.event.Event;
import javafx.event.EventHandler;
import Othello.Controller.Commands.CommandManager;
import Othello.Controller.Commands.MoveCommand;
import Othello.Model.Game;

public class ClickDiscHandler implements EventHandler {

    int row;
    int col;
    Game game;
    CommandManager commandManager;

    public ClickDiscHandler(int row, int col, Game game, CommandManager commandManager){
        this.row = row;
        this.col = col;
        this.game = game;
        this.commandManager = commandManager;
    }

    @Override
    public void handle(Event event) {
        MoveCommand moveCommand = new MoveCommand(game, row, col);
        commandManager.executeCommand(moveCommand);
    }
}