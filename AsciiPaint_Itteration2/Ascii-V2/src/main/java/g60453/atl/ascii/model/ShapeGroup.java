package g60453.atl.ascii.model;
import java.util.ArrayList;
import java.util.Arrays;

public class ShapeGroup implements ShapeCompenent {
    private final ArrayList<ShapeCompenent> shapes;

    public ShapeGroup(ShapeCompenent... newShapes) {
        shapes = new ArrayList<ShapeCompenent>();
        shapes.addAll(Arrays.asList(newShapes));
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

    @Override
    public Point getPoint() {
        return shapes.get(0).getPoint();
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
