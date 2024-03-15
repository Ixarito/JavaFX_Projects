package g60453.atl.ascii.model;

/**
 * Represents a component of a shape in a two-dimensional space.
 */
public interface ShapeCompenent {
    /**
     * Checks if a point is inside this shape component.
     *
     * @param p the point to check
     * @return true if the point is inside this shape component, false otherwise
     */
    boolean isInside(Point p);

    /**
     * Moves this shape component to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for this shape component
     * @param dy the new y-coordinate for this shape component
     */
    void move(double dx, double dy);

    /**
     * Sets the color of this shape component.
     *
     * @param newColor the new color for this shape component
     */
    void setColor(char newColor);

    /**
     * Returns the color of this shape component.
     *
     * @return the color of this shape component
     */
    char getColor();

    /**
     * Returns a new point with the same coordinates as the reference point of this shape component.
     *
     * @return a new point with the same coordinates as the reference point of this shape component
     */
    Point getPoint();

    /**
     * Returns a string representation of this shape component.
     *
     * @return a string representation of this shape component
     */
    public String toString();
}