package Othello.View.Interface;

import Othello.Controller.Interface.Handlers.CellClickHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import Othello.Model.*;

public class BoardView extends GridPane implements OthelloObserver {
    private Rectangle[][] cells;

    private Game game;

    public BoardView(Game game) {
        this.game = game;
        int size = game.getBoardSize();
        cells = new Rectangle[size][size];
        createCells(size);
    }

    private void createCells(int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                Rectangle cell = new Rectangle(30, 30);
                cell.setFill(Color.GREEN);
                cell.setStroke(Color.BLACK);

                // Add event listener for click events
                cell.addEventHandler(MouseEvent.MOUSE_CLICKED, new CellClickHandler(row, col, game));

                cells[row][col] = cell;
                add(cell, col, row);
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
                        cells[row][col].setFill(Color.BLACK);
                    } else {
                        cells[row][col].setFill(Color.WHITE);
                    }
                } else {
                    cells[row][col].setFill(Color.GREEN);
                }
            }
        }
    }
}
