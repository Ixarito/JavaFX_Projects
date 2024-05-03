package Othello.Model;

import Othello.View.Interface.BoardView;

import java.util.ArrayList;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;

    private ArrayList<BoardView> boardObservers;

    /**
     * Constructor for the game
     * @param player1 the first player
     * @param player2 the second player
     * @param size the size of the board
     */
    public Game(Player player1, Player player2, int size){
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1.getColor().equals(Color.BLACK) ? player1 : player2;
        this.board = new Board(size);
        boardObservers = new ArrayList<>();
    }

    /**
     * Adds an observer to the list
     * @param boardView the observer to add
     */
    public void registerObserver (BoardView boardView){
        boardObservers.add(boardView);
    }

    /**
     * removes an observer from the list
     * @param boardView the observer to remove
     */
    public void removeObserver (BoardView boardView){
        boardObservers.remove(boardView);
    }

    /**
     * Notifies all observers
     */
    public void notifyObservers(){
        for (BoardView view : boardObservers){
            view.update();
        }
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
     * @param row       the row of the move
     * @param col       the column of the move
     * @param player    the  player
     * @return true if the move was made, false otherwise
     */
    public void makeMove(int row, int col, Player player){
        if (board.makeMove(row, col, player.getColor())){
            switchPlayer();
            notifyObservers();
        }
    }

    /**
     * Switches the current player
     */
    public void switchPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
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
    public Player getWinner(){
        Color winnerColor = board.getWinner();
        if (winnerColor == Color.BLACK){
            return player1;
        } else if (winnerColor == Color.WHITE){
            return player2;
        } else {
            return null;
        }
    }

    /**
     * Returns a list of valid moves for the player
     *
     * @param player the player
     * @return a list of valid moves for the player
     */
    public ArrayList<Move> getValidMoves(Player player){
        return board.getValidMoves(player.getColor());
    }

}
