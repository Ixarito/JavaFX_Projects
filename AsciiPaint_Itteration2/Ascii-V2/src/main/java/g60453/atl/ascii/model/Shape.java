package g60453.atl.ascii.model;

/**
 * Represents a shape in a two-dimensional space.
 */
public interface Shape {
    /**
     * Checks if a point is inside this shape.
     *
     * @param p the point to check
     * @return true if the point is inside this shape, false otherwise
     */
    boolean isInside(Point p);

    /**
     * Moves this shape to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for this shape
     * @param dy the new y-coordinate for this shape
     */
    void move(double dx, double dy);

    /**
     * Sets the color of this shape.
     *
     * @param newColor the new color for this shape
     */
    void setColor(char newColor);

    /**
     * Returns the color of this shape.
     *
     * @return the color of this shape
     */
    char getColor();

    /**
     * Returns a new point with the same coordinates as the reference point of this shape.
     *
     * @return a new point with the same coordinates as the reference point of this shape
     */
    Point getPoint();
}