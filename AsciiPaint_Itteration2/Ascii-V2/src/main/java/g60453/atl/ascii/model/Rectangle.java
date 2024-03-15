package g60453.atl.ascii.model;

/**
 * Represents a rectangle in a two-dimensional space.
 */
public class Rectangle extends ColoredShape {
    private final Point upperLeft;
    private final double width;
    private final double height;

    /**
     * Constructs a new rectangle with the specified upper left point, width, height, and color.
     *
     * @param upperLeft the upper left point of the new rectangle
     * @param width the width of the new rectangle
     * @param height the height of the new rectangle
     * @param color the color of the new rectangle
     */
    Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Checks if a point is inside this rectangle.
     *
     * @param p the point to check
     * @return true if the point is inside this rectangle, false otherwise
     */
    public boolean isInside(Point p) {
        return p.getX() >= upperLeft.getX() && p.getX() <= upperLeft.getX() + width && p.getY() >= upperLeft.getY() && p.getY() <= upperLeft.getY() + height;
    }

    /**
     * Moves this rectangle to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for the upper left point of this rectangle
     * @param dy the new y-coordinate for the upper left point of this rectangle
     */
    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    /**
     * Returns a string representation of this rectangle.
     *
     * @return a string representation of this rectangle
     */
    public String toString() {
        return "Rectangle";
    }

    /**
     * Returns a new point with the same coordinates as the upper left point of this rectangle.
     *
     * @return a new point with the same coordinates as the upper left point of this rectangle
     */
    @Override
    public Point getPoint() {
        return new Point(upperLeft);
    }
}