package Othello.Model;

import java.util.ArrayList;

public class HardAi implements AiStrategy {

    @Override
    public Move chooseMove(ArrayList<Move> validMoves, Board board, Color color) {
        if (validMoves.isEmpty()){
            return null;
        }
        int bestMove = 0;
        int flips = 0;
        for(int index = 0; index < validMoves.size(); index++){
            int tempFlips = board.getFlips(validMoves.get(index).getRow(), validMoves.get(index).getCol(), color);
            if (flips < tempFlips){
                bestMove = index;
                flips = tempFlips;
            }
        }
        return validMoves.get(bestMove);
    }
}