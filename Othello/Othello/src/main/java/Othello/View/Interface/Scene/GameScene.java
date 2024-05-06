package Othello.View.Interface.Scene;

import Othello.Model.Game;
import Othello.View.Interface.Elements.BoardView;
import Othello.View.Interface.Elements.GameInfo;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class GameScene extends Scene {


    public GameScene(BoardView boardView, GameInfo gameInfo) {
        super(new HBox());
        VBox box = new VBox();
        box.getChildren().addAll(gameInfo, boardView);
        box.setAlignment(Pos.CENTER);

        HBox root = (HBox) this.getRoot();
        root.getChildren().add(box);
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.fill(Color.rgb(107, 207, 0)));
    }
}