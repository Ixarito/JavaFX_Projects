package model;

public class Circle extends ColoredShape {
    Point center;
    double radius;

    //TODO
    Circle(Point center, double radius, char color) {
        super(color);
        this.center = center;
        this.radius = radius;
    }

    //todo
    @Override
    public boolean isInside(Point p) {
        return false;
    }

    //todo
    @Override
    public void move(double dx, double dy) {

    }
}
