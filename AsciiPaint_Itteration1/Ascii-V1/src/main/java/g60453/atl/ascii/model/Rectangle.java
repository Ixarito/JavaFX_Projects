package g60453.atl.ascii.model;

public class Rectangle extends ColoredShape {
    private final Point upperLeft;
    private final double width;
    private final double height;

    Rectangle(Point upperLeft, double width, double height, char color) {
        super(color);
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    public boolean isInside(Point p) {
        return p.getX() >= upperLeft.getX() && p.getX() <= upperLeft.getX() + width && p.getY() >= upperLeft.getY() && p.getY() <= upperLeft.getY() + height;

    }

    public void move(double dx, double dy) {
        upperLeft.move(dx, dy);
    }

    public String toString() {
        return "Rectangle";
    }
}
