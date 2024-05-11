package Othello.Model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private Game game;
    private Player player1;
    private Player player2;

    @BeforeEach
    void setUp() {
        player1 = new Player("Player1", Color.BLACK);
        player2 = new Player("Bot", Color.WHITE);
        game = new Game(player1, player2, 8, new EasyAi());
    }

    @Test
    void testMakeMove() {
        game.makeMove(2, 3);
        assertEquals(Color.BLACK, game.getBoardGrid()[2][3].getColor());
    }

    @Test
    void testSkipMove() {
        game.skipMove();
        assertEquals(player1, game.getCurrentPlayer());
    }

    @Test
    void testIsValidMove() {
        assertTrue(game.isValidMove(2, 3));
        assertFalse(game.isValidMove(0, 0));
    }

}