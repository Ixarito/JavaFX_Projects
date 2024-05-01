package Othello.Model;

import javafx.util.Pair;

import java.util.ArrayList;

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

    /**
     * Returns true if the move is valid
     *
     * @param row        the row of the move
     * @param col        the column of the move
     * @param playerColor the color of the player
     * @return true if the move is valid, false otherwise
     */
    public boolean isValidMove(int row, int col, Color playerColor) {
        if (grid[row][col] != null) {
            return false;
        }

        Color opponentColor = (playerColor == Color.WHITE) ? Color.BLACK : Color.WHITE;

        for (Direction direction : Direction.values()) {
            int newRow = row + direction.getRowChange();
            int newCol = col + direction.getColumnChange();


            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size && grid[newRow][newCol] != null && grid[newRow][newCol].getColor() == opponentColor) {
                newRow += direction.getRowChange();
                newCol += direction.getColumnChange();


                while (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                    if (grid[newRow][newCol] == null) {
                        break;
                    } else if (grid[newRow][newCol].getColor() == playerColor) {
                        return true;
                    }

                    newRow += direction.getRowChange();
                    newCol += direction.getColumnChange();
                }
            }
        }

        return false; // No valid move found
    }

    /**
     * Makes a move on the board
     *
     * @param row        the row of the move
     * @param col        the column of the move
     * @param playerColor the color of the player
     * @return true if the move was made, false otherwise
     */
    public boolean makeMove(int row, int col, Color playerColor) {
        if (!isValidMove(row, col, playerColor)) {
            return false;
        }

        grid[row][col] = new Disc(playerColor);

        Color opponentColor = (playerColor == Color.WHITE) ? Color.BLACK : Color.WHITE;

        for (Direction direction : Direction.values()) {
            int newRow = row + direction.getRowChange();
            int newCol = col + direction.getColumnChange();


            if (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size && grid[newRow][newCol] != null && grid[newRow][newCol].getColor() == opponentColor) {
                newRow += direction.getRowChange();
                newCol += direction.getColumnChange();


                while (newRow >= 0 && newRow < size && newCol >= 0 && newCol < size) {
                    if (grid[newRow][newCol] == null) {
                        break;
                    } else if (grid[newRow][newCol].getColor() == playerColor) {

                        int flipRow = row + direction.getRowChange();
                        int flipCol = col + direction.getColumnChange();
                        while (flipRow != newRow || flipCol != newCol) {
                            grid[flipRow][flipCol].flip();
                            flipRow += direction.getRowChange();
                            flipCol += direction.getColumnChange();
                        }
                        break;
                    }

                    newRow += direction.getRowChange();
                    newCol += direction.getColumnChange();
                }
            }
        }

        return true; // The move was made
    }

    /**
     * Returns true if the game is over
     *
     * @return true or false if the game is over
     */
    public boolean isGameOver() {
        return getValidMoves(Color.WHITE).isEmpty() && getValidMoves(Color.BLACK).isEmpty();
    }

    /**
     * Returns the winner of the game
     *
     * @return the winner of the game, null if case of a draw
     */
    public Color getWinner() {
        int blackCount = 0;
        int whiteCount = 0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] != null) {
                    if (grid[row][col].getColor().equals(Color.BLACK)) {
                        blackCount++;
                    } else {
                        whiteCount++;
                    }
                }
            }
        }
        if (blackCount > whiteCount){
            return Color.BLACK;
        }
        if (whiteCount > blackCount) {
            return Color.WHITE;
        }
        return null;
    }


    /**
     * Returns a list of valid moves for the player
     *
     * @param player the player
     * @return a list of valid moves for the player
     */
    public ArrayList<Pair<Integer, Integer>> getValidMoves(Color player) {
        ArrayList<Pair<Integer, Integer>> validMoves = new ArrayList<>();

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (isValidMove(row, col, player)) {
                    validMoves.add(new Pair<>(row, col));
                }
            }
        }
        return validMoves;
    }


}
