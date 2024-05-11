package Othello.Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void makeMove() {
        Board board = new Board(4);
        ArrayList<Position> result = board.makeMove(0, 1, Color.BLACK);
        assertNotNull(result, "Expected non-null result for valid move");
        assertTrue(result.size() > 0, "Expected at least one disk to be flipped for valid move");

        ArrayList<Position> result2 = board.makeMove(0, 1, Color.BLACK);
        assertNull(result2, "Expected null result for invalid move");
    }

    @Test
    void isValidMove() {
        Board board = new Board(4);
        assertTrue(board.isValidMove(0, 2, Color.WHITE), "Expected move to be valid");
        assertFalse(board.isValidMove(0, 0, Color.WHITE), "Expected move to be invalid");
    }

    @Test
    void isGameOver() {
        Board board = new Board(8);
        assertFalse(board.isGameOver());
    }

    @Test
    void getWinner() {
        Board board = new Board(8);
        assertNull(board.getWinner());
    }

    @Test
    void getValidMoves() {
        Board board = new Board(8);
        ArrayList<Position> validMoves = board.getValidMoves(Color.WHITE);
        assertEquals(4, validMoves.size());
    }
}