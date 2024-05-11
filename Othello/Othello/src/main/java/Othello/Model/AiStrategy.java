package Othello.Model;

import java.util.ArrayList;

 public interface AiStrategy {
    Position chooseMove(ArrayList<Position> validMoves, Board board, Color color);
}
