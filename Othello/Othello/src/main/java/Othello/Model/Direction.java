package Othello.Model;

public enum Direction {
    UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT;

    /**
     * Returns the change in row for the direction
     * @return the change in row for the direction
     */
    public int getRowChange(){
        switch(this){
            case UP:
            case UP_LEFT:
            case UP_RIGHT:
                return -1;
            case DOWN:
            case DOWN_LEFT:
            case DOWN_RIGHT:
                return 1;
            default:
                return 0;
        }
    }

    /**
     * Returns the change in column for the direction
     * @return the change in column for the direction
     */
    public int getColumnChange(){
        switch(this){
            case LEFT:
            case UP_LEFT:
            case DOWN_LEFT:
                return -1;
            case RIGHT:
            case UP_RIGHT:
            case DOWN_RIGHT:
                return 1;
            default:
                return 0;
        }
    }

}
