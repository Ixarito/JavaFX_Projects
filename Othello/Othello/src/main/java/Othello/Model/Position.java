package Othello.Model;

/**
 * Represents a move on the board
 */
class Position {
    private final int row;
    private final int col;

    Position(int row, int col) {
        this.row = row;
        this.col = col;
    }

    int getCol() {
        return col;
    }

    int getRow() {
        return row;
    }
}
