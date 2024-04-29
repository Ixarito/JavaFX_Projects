package Othello.Model;

public class Player {
    private final String name;
    private final Color color;

    /**
     * Constructor for the player
     * @param name the name of the player
     * @param color the color of the player
     */
    public Player(String name, Color color){
        this.name = name;
        this.color = color;
    }

    /**
     * Returns the name of the player
     * @return the name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the color of the player
     * @return the color of the player
     */
    public Color getColor() {
        return color;
    }
}
