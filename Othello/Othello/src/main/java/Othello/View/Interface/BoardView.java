package Othello.View.Interface;

import Othello.Controller.Interface.Handlers.ClickDiscHandler;
import Othello.Controller.Interface.Handlers.HoverDiscHandler;
import Othello.Controller.Interface.Handlers.UnhoverDiscHandler;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import Othello.Model.*;

public class BoardView extends GridPane implements OthelloObserver {
    private Rectangle[][] cells;
    private Circle[][] discs;
    private Game game;

    public BoardView(Game game) {
        this.game = game;
        int size = game.getBoardSize();
        cells = new Rectangle[size][size];
        discs = new Circle[size][size];
        createCells(size);
        createDiscs(size);
    }

    private void createCells(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle cell = new Rectangle(50, 50);
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
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Circle disc = new Circle(20);
                disc.setTranslateX(5);

                // Create a drop shadow effect
                DropShadow dropShadow = new DropShadow();
                dropShadow.setRadius(10.0);
                dropShadow.setColor(Color.color(0,0,0,0.3));

                // Apply the drop shadow effect to the disc
                disc.setEffect(dropShadow);

                // Add event listener for click events
                disc.addEventHandler(MouseEvent.MOUSE_CLICKED, new ClickDiscHandler(row, col, game));
                disc.addEventHandler(MouseEvent.MOUSE_ENTERED, new HoverDiscHandler(row, col, game, disc));
                disc.addEventHandler(MouseEvent.MOUSE_EXITED, new UnhoverDiscHandler(row, col, game, disc));

                discs[row][col] = disc;
                add(disc, col, row);
            }
        }
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
