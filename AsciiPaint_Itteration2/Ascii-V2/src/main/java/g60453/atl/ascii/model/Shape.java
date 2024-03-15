package g60453.atl.ascii.model;

public interface Shape {
    boolean isInside(Point p);
    void move(double dx, double dy);

    void setColor(char newColor);
    char getColor();

    Point getPoint();
}