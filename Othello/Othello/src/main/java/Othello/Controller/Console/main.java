package Othello.Controller.Console;

import Othello.Model.*;
import Othello.View.Console.View;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        View.printMessage("Bienvenue dans le jeu Othello");

        View.printMessage("Entrez votre nom : ");
        String name = scanner.nextLine();

        View.printMessage("Entrez votre couleur (BLACK/WHITE) : ");
        Color color = Color.valueOf(scanner.nextLine().toUpperCase());

        View.printMessage("Entrez la taille du plateau : ");
        int size = scanner.nextInt();

        Player player = new Player(name, color);
        Player bot;

        if (player.getColor().equals(Color.BLACK)) {
            bot = new Player("Bot", Color.WHITE);
        } else {
            bot = new Player("Bot", Color.BLACK);
        }

        Game game = new Game(player, bot, size, new EasyAi());
        View.printBoard(game.getBoardGrid(), game.getBoardSize());

        while (!game.isGameOver()) {

            //Player's turn
            View.printMessage("Entrez la valeur de row (-1 pour passer le tour) : ");
            int row = scanner.nextInt();
            if (row == -1) {
                game.skipMove();
                continue;
            }

            View.printMessage("Entrez la valeur de col : ");
            int col = scanner.nextInt();

            if (game.isValidMove(row, col)) {
                game.makeMove(row, col);
            } else {
                View.printError("Invalid move. Please try again.");
            }

            View.clearConsole();
            View.printBoard(game.getBoardGrid(), game.getBoardSize());

        }
        View.printWinner(game.getWinner().getName());
    }
}