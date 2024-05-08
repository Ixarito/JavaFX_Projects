package Othello.Model;

import Othello.Controller.Interface.ControllerObserver;
import Othello.View.Interface.Elements.ViewObserver;

import java.util.ArrayList;
import java.util.Stack;

public class Game {
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private final Board board;
    private AiStrategy aiStrategy;
    private ArrayList<ViewObserver> boardObservers;
    private ArrayList<ControllerObserver> endGameObservers;
    private Stack<ArrayList<Position>> lastMoves;


    /**
     * Constructor for the game
     * @param player1 the first player
     * @param player2 the second player
     * @param size the size of the board
     */
    public Game(Player player1, Player player2, int size, AiStrategy aiStrategy){
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = player1.getColor().equals(Color.BLACK) ? player1 : player2;
        this.board = new Board(size);
        this.aiStrategy = aiStrategy;
        boardObservers = new ArrayList<>();
        endGameObservers = new ArrayList<>();
        lastMoves = new Stack<>();

        //if ai's color is white made the first move
        if (player2.equals(currentPlayer)){
            aiMove();
            updateScore();
            notifyObservers();
        }
    }

    /**
     * Makes the ai move
     */
    public void aiMove(){
        Position aiMove = aiStrategy.chooseMove(getValidMoves(player2), board, player2.getColor());
        if (aiMove != null){
            lastMoves.push(board.makeMove(aiMove.getRow(),aiMove.getCol(), player2.getColor()));
        }
        switchPlayer();
    }

    /**
     * Makes a move on the board
     *
     * @param row       the row of the move
     * @param col       the column of the move
     * @return true if the move was made, false otherwise
     */
    public void makeMove(int row, int col){
        if (currentPlayer != player1){
            return;
        }
        ArrayList<Position> move = board.makeMove(row, col, player1.getColor());
        if (move != null){
            lastMoves.push(move);
            switchPlayer();
            aiMove();
        }
        updateScore();
        notifyObservers();
        if (isGameOver()){
            notifyEndGameObservers(getWinner());
        }
    }

    public void skipMove(){
        switchPlayer();
        aiMove();
        updateScore();
        notifyObservers();
        if (isGameOver()){
            notifyEndGameObservers(getWinner());
        }
    }

    public void undoMove(){
        if (lastMoves.size() <= 2){
            return;
        }
        for (int i = 0; i < 2; i++){
            board.undoMove(lastMoves.pop());
        }
        updateScore();
        notifyObservers();
    }

    /**
     * Adds an observer to the list
     *
     * @param observer the observer to add
     */
    public void registerObserver (ViewObserver observer){
        boardObservers.add(observer);
    }

    /**
     * removes an observer from the list
     * @param observer the observer to remove
     */
    public void removeObserver (ViewObserver observer){
        boardObservers.remove(observer);
    }

    /**
     * Adds an observer to the list
     *
     * @param observer the observer to add
     */
    public void registerEndGameObserver (ControllerObserver observer){
        endGameObservers.add(observer);
    }

    /**
     * removes an observer from the list
     * @param observer the observer to remove
     */
    public void removeEndGameObserver (ControllerObserver observer){
        endGameObservers.remove(observer);
    }

    /**
     * Notifies all observers
     */
    public void notifyObservers(){
        for (ViewObserver view : boardObservers){
            view.update();
        }
    }

    /**
     * Notifies all observers
     */
    public void notifyEndGameObservers(Player player){
        for (ControllerObserver controller : endGameObservers){
            controller.update(player);
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
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
     * Switches the current player
     */
    public void switchPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    public void updateScore(){
        player1.setScore(board.countDiscs(player1.getColor()));
        player2.setScore(board.countDiscs(player2.getColor()));
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
        if (winnerColor == player1.getColor()){
            return player1;
        } else if (winnerColor == player2.getColor()){
            return player2;
        } else {
            return null;
        }
    }

    /**
     * Returns true if the move is valid of the current player
     *
     * @param row        the row of the move
     * @param col        the column of the move
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(int row, int col) {
        return board.isValidMove(row, col, currentPlayer.getColor());
    }

    /**
     * Returns a list of valid moves for the player
     *
     * @param player the player
     * @return a list of valid moves for the player
     */
    public ArrayList<Position> getValidMoves(Player player){
        return board.getValidMoves(player.getColor());
    }

}
