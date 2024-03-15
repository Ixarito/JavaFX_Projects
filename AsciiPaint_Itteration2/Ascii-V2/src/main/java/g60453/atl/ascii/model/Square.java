package g60453.atl.ascii.model;

/**
 * Represents a square in a two-dimensional space.
 */
public class Square extends Rectangle {
    /**
     * Constructs a new square with the specified upper left point, side length, and color.
     *
     * @param upperLeft the upper left point of the new square
     * @param side the side length of the new square
     * @param color the color of the new square
     */
    Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

    /**
     * Returns a string representation of this square.
     *
     * @return a string representation of this square
     */
    public String toString() {
        return "Square";
    }
}