package Othello.View.Interface.Elements;


import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import Othello.Model.*;
import javafx.stage.Screen;

public class BoardView extends GridPane implements ViewObserver {
    double screenHeight;
    private Rectangle[][] cells;
    private Circle[][] discs;
    private Game game;

    public BoardView(Game game) {
        this.game = game;
        screenHeight = Screen.getPrimary().getVisualBounds().getHeight();
        int size = game.getBoardSize();
        cells = new Rectangle[size][size];
        discs = new Circle[size][size];
        createCells(size);
        createDiscs(size);
    }

    private void createCells(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle cell = new Rectangle((screenHeight-400)/size, (screenHeight-400)/size);
                if (row % 2 == 0) {
                    if (col % 2 == 0) {
                        cell.setFill(Color.rgb(107, 207, 0));
                    } else {
                        cell.setFill(Color.rgb(97, 176, 0));
                    }
                } else {
                    if (col % 2 != 0) {
                        cell.setFill(Color.rgb(107, 207, 0));
                    } else {
                        cell.setFill(Color.rgb(97, 176, 0));
                    }
                }

                cells[row][col] = cell;
                add(cell, col, row);
            }
        }
    }

    private void createDiscs(int size) {

        double cellSize = (screenHeight-400)/size;
        double discRadius = cellSize/2 - cellSize/10; // 10% padding
        double discTranslation = cellSize/10; // 10% translation

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {


                Circle disc = new Circle((discRadius));

                //center the disc
                disc.setTranslateX(discTranslation);

                // Drop shadow
                DropShadow dropShadow = new DropShadow();
                dropShadow.setRadius(40.0);
                dropShadow.setColor(Color.color(0,0,0,0.3));
                disc.setEffect(dropShadow);

                discs[row][col] = disc;
                add(disc, col, row);
            }
        }
    }

    public Circle[][] getDiscs() {
        return discs;
    }

    @Override
    public void update() {
        for (int row = 0; row < game.getBoardSize(); row++) {
            for (int col = 0; col < game.getBoardSize(); col++) {
                Disc disc = game.getBoardGrid()[row][col];
                if (disc != null) {
                    if (disc.getColor() == Othello.Model.Color.BLACK) {

                        discs[row][col].setFill(Color.BLACK);
                    } else {
                        discs[row][col].setFill(Color.WHITE);
                    }
                } else {
                    discs[row][col].setFill(Color.TRANSPARENT);
                }
            }
        }
    }
}
