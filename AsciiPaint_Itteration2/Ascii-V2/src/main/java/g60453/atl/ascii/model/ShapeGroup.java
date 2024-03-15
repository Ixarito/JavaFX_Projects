package g60453.atl.ascii.model;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Represents a group of shape components in a two-dimensional space.
 */
public class ShapeGroup implements ShapeCompenent {
    private final ArrayList<ShapeCompenent> shapes;

    /**
     * Constructs a new shape group with the specified shape components.
     *
     * @param newShapes the shape components of the new shape group
     */
    public ShapeGroup(ShapeCompenent... newShapes) {
        shapes = new ArrayList<ShapeCompenent>();
        shapes.addAll(Arrays.asList(newShapes));
    }

    /**
     * Moves this shape group to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for this shape group
     * @param dy the new y-coordinate for this shape group
     */
    public void move(double dx, double dy) {
        for (ShapeCompenent shape : shapes) {
            shape.move(dx, dy);
        }
    }

    /**
     * Sets the color of this shape group.
     *
     * @param newColor the new color for this shape group
     */
    public void setColor(char newColor) {
        for (ShapeCompenent shape : shapes) {
            shape.setColor(newColor);
        }
    }

    /**
     * Returns the color of this shape group.
     *
     * @return the color of this shape group
     */
    public char getColor() {
        return shapes.get(0).getColor();
    }

    /**
     * Returns a new point with the same coordinates as the reference point of this shape group.
     *
     * @return a new point with the same coordinates as the reference point of this shape group
     */
    @Override
    public Point getPoint() {
        return shapes.get(0).getPoint();
    }

    /**
     * Checks if a point is inside this shape group.
     *
     * @param p the point to check
     * @return true if the point is inside this shape group, false otherwise
     */
    public boolean isInside(Point p) {
        for (ShapeCompenent shape : shapes) {
            if (shape.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns a string representation of this shape group.
     *
     * @return a string representation of this shape group
     */
    public String toString() {
        return "group" + shapes.toString();
    }

    /**
     * Returns the shape components of this shape group.
     *
     * @return the shape components of this shape group
     */
    public ArrayList<ShapeCompenent> getShapes() {
        return shapes;
    }
}