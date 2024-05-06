package Othello.View.Interface.Scene;


import Othello.View.Interface.Elements.MainMenu;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainMenuScene extends Scene {


    public MainMenuScene(MainMenu mainMenu) {
        super(new HBox());
        VBox box = new VBox();
        box.getChildren().addAll(mainMenu);
        box.setAlignment(Pos.CENTER);

        DropShadow dropShadow = new DropShadow();
        dropShadow.setRadius(500);
        dropShadow.setColor(Color.rgb(255, 255, 255, 0.5));
        mainMenu.setEffect(dropShadow);

        HBox root = (HBox) this.getRoot();
        root.getChildren().add(box);
        root.setAlignment(Pos.CENTER);
        root.setBackground(Background.fill(Color.BLACK));
    }
}