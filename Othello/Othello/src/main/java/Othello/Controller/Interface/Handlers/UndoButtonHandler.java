package Othello.Controller.Interface.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Othello.Controller.Commands.CommandManager;

public class UndoButtonHandler implements EventHandler<ActionEvent> {
    private CommandManager commandManager;

    public UndoButtonHandler(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void handle(ActionEvent event) {
        commandManager.undo();
    }
}