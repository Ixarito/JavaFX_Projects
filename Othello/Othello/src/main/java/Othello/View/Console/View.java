package Othello.View.Console;

import Othello.Model.Disc;

public class View {

    public static void printMessage(String message){
        System.out.println(message);
    }
    public static void clearConsole() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void printError(String errorMessage){
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_RESET = "\u001B[0m";
        System.out.println(ANSI_RED + errorMessage + ANSI_RESET);
    }

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

    public static void printWinner(String winner){
        System.out.println("The winner is " + winner);
    }



}
