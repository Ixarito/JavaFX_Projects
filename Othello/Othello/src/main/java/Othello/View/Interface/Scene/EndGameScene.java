package Othello.View.Interface.Scene;

import Othello.Controller.Interface.ActionsHandlers.SkipButtonHandler;
import Othello.Model.Game;
import Othello.Model.Player;
import Othello.View.Interface.Elements.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class EndGameScene extends Scene {

    Label winnerLabbel;

    public EndGameScene(EndGameMenu endGameMenu) {
        super(new HBox());
        VBox box = new VBox();
        box.getChildren().addAll(endGameMenu);
        box.setAlignment(Pos.CENTER);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(500);
        dropShadow.setColor(Color.rgb(255, 255, 255, 0.5));
        endGameMenu.setEffect(dropShadow);

        HBox root = (HBox) this.getRoot();
        root.getChildren().add(box);
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.fill(Color.BLACK));
    }
}