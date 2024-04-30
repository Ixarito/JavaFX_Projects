package Othello.Model;

public class Board {

    private final int size;
    private final Disc[][] grid;

    /**
     * Constructor for the board
     *
     * @param size the size of the board
     */
    public Board(int size) {
        this.size = size;
        this.grid = new Disc[size][size];
        this.grid[size / 2 - 1][size / 2 - 1] = new Disc(Color.WHITE);
        this.grid[size / 2][size / 2] = new Disc(Color.WHITE);
        this.grid[size / 2 - 1][size / 2] = new Disc(Color.BLACK);
        this.grid[size / 2][size / 2 - 1] = new Disc(Color.BLACK);
    }

    /**
     * Returns the size of the board
     *
     * @return the size of the board
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the grid of the board
     *
     * @return the grid of the board
     */
    public Disc[][] getGrid() {
        return grid;
    }

    public boolean isValidMove(int row, int col, Color playerColor) {
        //TODO
        return true;
    }

    public boolean makeMove(int row, int col, Color playerColor) {
        //TODO
        return true;
    }

    public boolean isGameOver() {
        //TODO
        return true;
    }

    public boolean getWinner() {
        //TODO
        return true;
    }

    public boolean getValidMoves(char player) {
        //TODO
        return true;
    }


}
