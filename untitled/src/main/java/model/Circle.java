package model;

public class Circle extends ColoredShape {
    Point center;
    double radius;

    Circle(Point center, double radius, char color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    public boolean isInside(Point p) {
        double distance = center.distanceTo(p);
        return distance < radius;
    }

    public void move(double dx, double dy) {
        center.move(dx, dy);
    }
}
