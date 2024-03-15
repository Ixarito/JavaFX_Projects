package g60453.atl.ascii.model;

/**
 * Represents a leaf node in a composite structure of shapes.
 */
public class ShapeLeaf implements ShapeCompenent{
    private final Shape shape;

    /**
     * Constructs a new shape leaf with the specified shape.
     *
     * @param shape the shape of the new shape leaf
     */
    public ShapeLeaf(Shape shape) {
        this.shape = shape;
    }

    /**
     * Checks if a point is inside this shape leaf.
     *
     * @param p the point to check
     * @return true if the point is inside this shape leaf, false otherwise
     */
    @Override
    public boolean isInside(Point p) {
        return shape.isInside(p);
    }

    /**
     * Moves this shape leaf to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for this shape leaf
     * @param dy the new y-coordinate for this shape leaf
     */
    @Override
    public void move(double dx, double dy) {
        shape.move(dx, dy);
    }

    /**
     * Sets the color of this shape leaf.
     *
     * @param newColor the new color for this shape leaf
     */
    @Override
    public void setColor(char newColor) {
        shape.setColor(newColor);
    }

    /**
     * Returns the color of this shape leaf.
     *
     * @return the color of this shape leaf
     */
    @Override
    public char getColor() {
        return shape.getColor();
    }

    /**
     * Returns a new point with the same coordinates as the reference point of this shape leaf.
     *
     * @return a new point with the same coordinates as the reference point of this shape leaf
     */
    @Override
    public Point getPoint() {
        return shape.getPoint();
    }

    /**
     * Returns a string representation of this shape leaf.
     *
     * @return a string representation of this shape leaf
     */
    @Override
    public String toString() {
        return shape.toString();
    }
}