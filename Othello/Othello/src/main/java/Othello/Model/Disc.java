package Othello.Model;

public class Disc {

    private final Color color;

    /**
     * Constructor for the disc
     * @param color the color of the disc
     */
    public Disc(Color color){
        this.color = color;
    }

    /**
     * Returns the color of the disc
     * @return the color of the disc
     */
    public Color getColor() {
        return color;
    }
}
