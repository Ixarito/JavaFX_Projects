package g60453.atl.ascii.model;

/**
 * Represents a colored shape in a two-dimensional space.
 */
public abstract class ColoredShape implements Shape {
    private char color;

    /**
     * Constructs a new colored shape with the specified color.
     *
     * @param color the color of the new colored shape
     */
    ColoredShape(char color) {
        this.color = color;
    }

    /**
     * Returns the color of this colored shape.
     *
     * @return the color of this colored shape
     */
    public char getColor() {
        return color;
    }

    /**
     * Sets the color of this colored shape.
     *
     * @param color the new color for this colored shape
     */
    public void setColor(char color) {
        this.color = color;
    }
}