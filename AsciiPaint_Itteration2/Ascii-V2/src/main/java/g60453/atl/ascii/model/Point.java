package g60453.atl.ascii.model;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

/**
 * Represents a point in a two-dimensional space.
 */
public class Point {
    private double x;
    private double y;

    /**
     * Constructs a new point with the specified x and y coordinates.
     *
     * @param x the x-coordinate of the new point
     * @param y the y-coordinate of the new point
     */
    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Constructs a new point with the same coordinates as the specified point.
     *
     * @param p the point from which to copy the coordinates
     */
    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    /**
     * Returns the x-coordinate of this point.
     *
     * @return the x-coordinate of this point
     */
    public double getX() {
        return x;
    }

    /**
     * Returns the y-coordinate of this point.
     *
     * @return the y-coordinate of this point
     */
    public double getY() {
        return y;
    }

    /**
     * Moves this point to the specified location in the (x, y) coordinate plane.
     *
     * @param dx the new x-coordinate for this point
     * @param dy the new y-coordinate for this point
     */
    public void move(double dx, double dy) {
        this.x = dx;
        this.y = dy;
    }

    /**
     * Returns the distance from this point to a specified point.
     *
     * @param p the other point
     * @return the distance from this point to the specified point
     */
    double distanceTo(Point p) {
        return sqrt(pow((this.x - p.x),2) + pow((this.y - p.y),2));
    }
}