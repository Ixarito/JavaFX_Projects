package Othello.Controller.Console;

import Othello.Model.Board;
import Othello.Model.Color;
import Othello.Model.Disc;
import Othello.View.Console.View;

public class main {
    public static void main(String[] args) {
        //Board
        Board board = new Board(4);
        board.makeMove(2, 0, Color.WHITE);
        System.out.println(board.getWinner());


        View.printBoard(board.getGrid(), board.getSize());






    }
}
