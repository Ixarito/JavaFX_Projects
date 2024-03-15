package g60453.atl.ascii.model;

public class ShapeLeaf implements ShapeCompenent{
    private final Shape shape;

    public ShapeLeaf(Shape shape) {
        this.shape = shape;
    }
    @Override
    public boolean isInside(Point p) {
        return shape.isInside(p);
    }
    @Override
    public void move(double dx, double dy) {
        shape.move(dx, dy);
    }
    @Override
    public void setColor(char newColor) {
        shape.setColor(newColor);
    }
    @Override
    public char getColor() {
        return shape.getColor();
    }
    @Override
    public Point getPoint() {
        return shape.getPoint();
    }
    @Override
    public String toString() {
        return shape.toString();
    }



}