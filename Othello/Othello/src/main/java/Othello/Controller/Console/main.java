package Othello.Controller.Console;

import Othello.Model.*;
import Othello.View.Console.View;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class main {
//    public static void main(String[] args) {
//
//        Scanner scanner = new Scanner(System.in);
//        View.printMessage("Bienvenue dans le jeu Othello");
//
//        View.printMessage("Entrez votre nom : ");
//        String name = scanner.nextLine();
//
//        View.printMessage("Entrez votre couleur (BLACK/WHITE) : ");
//        Color color = Color.valueOf( scanner.nextLine().toUpperCase());
//
//        View.printMessage("Entrez la taille du plateau : ");
//        int size = scanner.nextInt();
//
//        Player player = new Player(name, color);
//        Player bot;
//
//        if (player.getColor().equals(Color.BLACK)) {
//            bot = new Player("Bot", Color.WHITE);
//        } else {
//            bot = new Player("Bot", Color.BLACK);
//        }
//
//
//
//        Game game = new Game(player, bot, size, true);
//        View.printBoard(game.getBoardGrid(), game.getBoardSize());
//
//
//
//        while (!game.isGameOver()) {
//
//            if (game.getCurrentPlayer().equals(player)) {
//                //Player's turn
//                View.printMessage("Entrez la valeur de row (-1 pour passer le tour) : ");
//                int row = scanner.nextInt();
//                if (row == -1) {
//                    game.switchPlayer();
//                    continue;
//                }
//
//                View.printMessage("Entrez la valeur de col : ");
//                int col = scanner.nextInt();
//
//                game.makeMove(row, col, player);
//
//            } else {
//                //Ai's turn
//                ArrayList<Move> moves = game.getValidMoves(bot);
//                if (moves.isEmpty()) {
//                    game.switchPlayer();
//                    continue;
//                }
//                int moveIndex = (int) (Math.random() * moves.size());
//                game.makeMove(moves.get(moveIndex).getRow(), moves.get(moveIndex).getCol(), bot);
//            }
//            View.clearConsole();
//            View.printBoard(game.getBoardGrid(), game.getBoardSize());
//        }
//        View.printWinner(game.getWinner().getName());
//
//
//    }
}
