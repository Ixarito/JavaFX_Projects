package Othello.Controller.Interface.Handlers;

import Othello.Model.Game;
import javafx.event.Event;
import javafx.event.EventHandler;

public class SkipButtonHandler implements EventHandler {

    private Game game;

    public SkipButtonHandler(Game game) {
        this.game = game;
    }
    @Override
    public void handle(Event event) {
        game.skipMove();
    }
}
