package model;

public class Rectangle extends ColoredShape {
    Point upperLeft;
    double width;
    double height;

    Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public boolean isInside(Point p) {
        return p.x >= upperLeft.x && p.x <= upperLeft.x + width && p.y >= upperLeft.y && p.y <= upperLeft.y + height;
    }

    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }
}
