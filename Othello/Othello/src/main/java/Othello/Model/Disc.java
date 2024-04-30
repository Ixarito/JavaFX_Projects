package Othello.Model;

public class Disc {

    private Color color;

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

    public void flip(){
        if(this.color.equals(Color.WHITE)){
            this.color = Color.BLACK;
        } else {
            this.color = Color.WHITE;
        }
    }
}
