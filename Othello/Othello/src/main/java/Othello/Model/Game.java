package Othello.Model;

import javafx.util.Pair;

import java.util.ArrayList;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    /**
     * Constructor for the game
     * @param player1 the first player
     * @param player2 the second player
     * @param board the board
     */
    public Game(Player player1, Player player2, Board board){
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1.getColor().equals(Color.BLACK) ? player1 : player2;
        this.board = board;
    }

    /**
     * Returns the current player
     * @return the first player
     */
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns the board
     * @return the board
     */
    public Disc[][] getBoardGrid() {
        return board.getGrid();
    }

    /**
     * Returns the grid of the board
     *
     * @return the grid of the board
     */
    public int getBoardSize(){
        return board.getSize();
    }


    /**
     * Makes a move on the board
     *
     * @param row        the row of the move
     * @param col        the column of the move
     * @param playerColor the color of the player
     * @return true if the move was made, false otherwise
     */
    public void makeMove(int row, int col, Color playerColor){
        if (board.makeMove(row, col, playerColor)){
            currentPlayer = (currentPlayer == player1) ? player2 : player1;
        }
    }

    /**
     * Returns true if the game is over
     *
     * @return true or false if the game is over
     */
    public boolean isGameOver(){
        return board.isGameOver();
    }

    /**
     * Returns the winner of the game
     *
     * @return the winner of the game, null if case of a draw
     */
    public Color getWinner(){
        return board.getWinner();
    }

    /**
     * Returns a list of valid moves for the player
     *
     * @param player the player
     * @return a list of valid moves for the player
     */
    public ArrayList<Pair<Integer, Integer>> getValidMoves(Color playerColor){
        return board.getValidMoves(playerColor);
    }

}
