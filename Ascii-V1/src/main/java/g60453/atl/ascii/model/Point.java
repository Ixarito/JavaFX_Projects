package g60453.atl.ascii.model;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Point {
    private double x;
    private double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void move(double dx, double dy) {
        this.x = dx;
        this.y = dy;
    }

    double distanceTo(Point p) {
        return sqrt(pow((this.x - p.x),2) + pow((this.y - p.y),2));
    }


}
