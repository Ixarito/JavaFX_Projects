package Othello.Controller.Interface.ActionsHandlers;

import Othello.Model.Game;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SkipButtonHandler implements EventHandler {

    Game game;

    public SkipButtonHandler(Game game) {
        this.game = game;
    }
    @Override
    public void handle(Event event) {
        game.skipMove();
    }
}
