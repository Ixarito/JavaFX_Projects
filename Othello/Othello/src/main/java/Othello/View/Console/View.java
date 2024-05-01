package Othello.View.Console;

import Othello.Model.Disc;

public class View {

    public static void printBoard(Disc[][] grid, int size){
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_WHITE = "\u001B[37m";
        final String ANSI_RESET = "\u001B[0m";

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (grid[i][j] == null) {
                    System.out.print(ANSI_WHITE + ". " + ANSI_RESET);
                } else if (grid[i][j].getColor().toString().equals("WHITE")) {
                    System.out.print("0 ");
                } else {
                    System.out.print(ANSI_RED + "0 " + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }
}
