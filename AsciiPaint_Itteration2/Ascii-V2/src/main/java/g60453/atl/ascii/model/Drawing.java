package g60453.atl.ascii.model;
import java.util.Arrays;
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

    public void group(int... indexes){
        ShapeCompenent[] shapesArray = new ShapeCompenent[indexes.length];
        for (int i = 0; i < indexes.length; i++){
            shapesArray[i] = shapes.get(indexes[i]);
        }
        ShapeGroup group = new ShapeGroup(shapesArray);
        Arrays.sort(indexes);
        for (int i = indexes.length - 1; i >= 0; i--){
            shapes.remove(indexes[i]);
        }
        shapes.add(group);
    }

    /**
     *
     * @param index
     * @return the size of the group, used in case of an undo
     */
    public int ungroup(int index){
        ShapeGroup group = (ShapeGroup) shapes.get(index);
        shapes.remove(index);
        shapes.addAll(group.getShapes());
        return group.getShapes().size();
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

    /**
     * Set a shape in the list at an index, used only for undo
     * @param index
     * @param shape
     */
    public void SetIndexShape(int index, ShapeCompenent shape){
        shapes.add(index, shape);
    }
}
