package Othello.Model;

import java.util.ArrayList;

public interface AiStrategy {
    Move chooseMove(ArrayList<Move> validMoves, Board board, Color color);
}
