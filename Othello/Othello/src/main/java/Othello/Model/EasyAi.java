package Othello.Model;

import java.util.ArrayList;

public class EasyAi implements AiStrategy {

    @Override
    public Position chooseMove(ArrayList<Position> validMoves, Board board, Color color) {
        if (validMoves.isEmpty()){
            return null;
        }
        int moveIndex = (int) (Math.random() * validMoves.size());
        return validMoves.get(moveIndex);
    }
}