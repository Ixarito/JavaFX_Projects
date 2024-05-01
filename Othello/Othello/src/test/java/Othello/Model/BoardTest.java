package Othello.Model;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    @Test
    void isValidMove() {
        Board board = new Board(4);
        assertTrue(board.isValidMove(2, 3, Color.WHITE));
        assertFalse(board.isValidMove(0, 0, Color.WHITE));
    }

    @Test
    void makeMove() {
        Board board = new Board(4);
        assertTrue(board.makeMove(2, 3, Color.WHITE));
        assertFalse(board.makeMove(0, 0, Color.WHITE));
    }

    @Test
    void isGameOver() {
        Board board = new Board(4);
        assertFalse(board.isGameOver());
        board.makeMove(0, 0, Color.BLACK);
        board.makeMove(0, 1, Color.BLACK);
        board.makeMove(0, 2, Color.BLACK);
        board.makeMove(0, 3, Color.BLACK);
        board.makeMove(1, 0, Color.BLACK);
        board.makeMove(1, 1, Color.BLACK);
        board.makeMove(1, 2, Color.BLACK);
        board.makeMove(1, 3, Color.BLACK);
        board.makeMove(2, 0, Color.BLACK);
        board.makeMove(2, 1, Color.BLACK);
        board.makeMove(2, 2, Color.BLACK);
        board.makeMove(2, 3, Color.BLACK);
        board.makeMove(3, 0, Color.BLACK);
        board.makeMove(3, 1, Color.BLACK);
        board.makeMove(3, 2, Color.BLACK);
        board.makeMove(3, 3, Color.BLACK);
        assertTrue(board.isGameOver());
    }

    @Test
    void getWinner_BlackWins() {
        Board board = new Board(4);
        board.makeMove(0, 0, Color.BLACK);
        board.makeMove(0, 1, Color.BLACK);
        board.makeMove(0, 2, Color.BLACK);
        board.makeMove(0, 3, Color.BLACK);
        assertEquals(Color.BLACK, board.getWinner());
    }

    @Test
    void getWinner_WhiteWins() {
        Board board = new Board(4);
        board.makeMove(0, 0, Color.WHITE);
        board.makeMove(0, 1, Color.WHITE);
        board.makeMove(0, 2, Color.WHITE);
        board.makeMove(0, 3, Color.WHITE);
        assertEquals(Color.WHITE, board.getWinner());
    }

    @Test
    void getValidMoves() {
        Board board = new Board(4);
        ArrayList<Pair<Integer, Integer>> validMoves = board.getValidMoves(Color.WHITE);
        assertEquals(4, validMoves.size());
        assertTrue(validMoves.contains(new Pair<>(2, 3)));
        assertTrue(validMoves.contains(new Pair<>(3, 2)));
        assertTrue(validMoves.contains(new Pair<>(2, 1)));
        assertTrue(validMoves.contains(new Pair<>(1, 2)));
    }
}