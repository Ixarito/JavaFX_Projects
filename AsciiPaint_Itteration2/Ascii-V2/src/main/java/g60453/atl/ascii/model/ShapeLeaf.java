package g60453.atl.ascii.model;

public class ShapeLeaf implements ShapeCompenent{
    private final Shape shape;

    public ShapeLeaf(Shape shape) {
        this.shape = shape;
    }

    public boolean isInside(Point p) {
        return shape.isInside(p);
    }

    public void move(double dx, double dy) {
        shape.move(dx, dy);
    }

    public void setColor(char newColor) {
        shape.setColor(newColor);
    }

    public char getColor() {
        return shape.getColor();
    }

    public String toString() {
        return shape.toString();
    }
}
