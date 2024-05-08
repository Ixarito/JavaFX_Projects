package Othello.Controller.Interface.Handlers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import Othello.Controller.Commands.CommandManager;

public class RedoButtonHandler implements EventHandler<ActionEvent> {
    private CommandManager commandManager;

    public RedoButtonHandler(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    @Override
    public void handle(ActionEvent event) {
        commandManager.redo();
    }
}