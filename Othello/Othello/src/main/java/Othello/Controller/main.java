package Othello.Controller;

import Othello.Model.Board;
import Othello.Model.Disc;

public class main {
    public static void main(String[] args) {
        //Board
        Board board = new Board(15);
        //print board
        Disc[][] grid = board.getGrid();
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (grid[i][j] == null) {
                    System.out.print("0 ");
                } else if (grid[i][j].getColor().toString().equals("WHITE")) {
                    System.out.print("W ");
                } else {
                    System.out.print("B ");
                }
            }
            System.out.println();
        }
    }
}
