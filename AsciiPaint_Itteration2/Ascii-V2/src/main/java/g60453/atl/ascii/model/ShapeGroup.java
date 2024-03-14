package g60453.atl.ascii.model;
import java.util.ArrayList;

public class ShapeGroup implements ShapeCompenent {
    private final ArrayList<ShapeCompenent> shapes;

    public ShapeGroup() {
        shapes = new ArrayList<ShapeCompenent>();
    }

    public void addShape(ShapeCompenent shape) {
        shapes.add(shape);
    }

    public void removeShape(int index) {
        shapes.remove(index);
    }

    public void move(double dx, double dy) {
        for (ShapeCompenent shape : shapes) {
            shape.move(dx, dy);
        }
    }

    public void setColor(char newColor) {
        for (ShapeCompenent shape : shapes) {
            shape.setColor(newColor);
        }
    }

    public char getColor() {
        return shapes.get(0).getColor();
    }

    public boolean isInside(Point p) {
        for (ShapeCompenent shape : shapes) {
            if (shape.isInside(p)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "group" + shapes.toString();
    }

    public ArrayList<ShapeCompenent> getShapes() {
        return shapes;
    }



}
