package Othello.Model;

public class Game {
    private final Player player1;
    private final Player player2;
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
        this.board = board;
    }

    /**
     * Returns the first player
     * @return the first player
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Returns the second player
     * @return the second player
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Returns the board
     * @return the board
     */
    public Board getBoard() {
        return board;
    }
}
