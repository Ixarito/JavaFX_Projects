package g60453.atl.ascii.model;

/**
 * Represents a circle in a two-dimensional space.
 */
public class Circle extends ColoredShape {
    private Point center;
    private final double radius;

    /**
     * Constructs a new circle with the specified center point, radius, and color.
     *
     * @param center the center point of the new circle
     * @param radius the radius of the new circle
     * @param color the color of the new circle
     */
    Circle(Point center, double radius, char color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    /**
     * Checks if a point is inside this circle.
     *
     * @param p the point to check
     * @return true if the point is inside this circle, false otherwise
     */
    public boolean isInside(Point p) {
        double distance = center.distanceTo(p);
        return distance < radius;
    }

    /**
     * Moves this circle to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for this circle
     * @param dy the new y-coordinate for this circle
     */
    public void move(double dx, double dy) {
        center.move(dx, dy);
    }

    /**
     * Returns a new point with the same coordinates as the center point of this circle.
     *
     * @return a new point with the same coordinates as the center point of this circle
     */
    @Override
    public Point getPoint() {
        return new Point(center);
    }

    /**
     * Returns a string representation of this circle.
     *
     * @return a string representation of this circle
     */
    public String toString() {
        return "Circle";
    }
}