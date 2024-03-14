package g60453.atl.ascii.model;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Drawing{
    private final List<ShapeCompenent> shapes;
    private final int height;
    private final int width;

    Drawing(){
        shapes = new ArrayList<ShapeCompenent>();
        height = 0;
        width = 0;
    }

    Drawing(int width, int height){
        shapes = new ArrayList<ShapeCompenent>();
        this.height = height;
        this.width = width;
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public List<ShapeCompenent> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    public void addShape(ShapeCompenent shape){
        shapes.add(shape);
    }


    public void removeShape(int index){
        shapes.remove(index);
    }

    public void group(int index1, int index2){
        ShapeGroup group = new ShapeGroup();
        group.addShape(shapes.get(index1));
        group.addShape(shapes.get(index2));
        if (index2 > index1){
            shapes.remove(index2);
            shapes.remove(index1);
        } else {
            shapes.remove(index1);
            shapes.remove(index2);
        }shapes.add(group);
    }

    public void ungroup(int index){
        ShapeGroup group = (ShapeGroup) shapes.get(index);
        shapes.remove(index);
        shapes.addAll(group.getShapes());
    }

    public void setColor(int index, char newColor){
        shapes.get(index).setColor(newColor);
    }


    public void moveShape(int index, double dx, double dy){
        shapes.get(index).move(dx, dy);
    }


    public ShapeCompenent getShape(Point p){
        for (ShapeCompenent s : shapes) {
            if (s.isInside(p)) {
                return s;
            }
        }
        return null;
    }
}
