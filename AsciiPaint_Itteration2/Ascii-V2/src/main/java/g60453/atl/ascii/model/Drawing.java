package g60453.atl.ascii.model;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Represents a drawing composed of shape components in a two-dimensional space.
 */
public class Drawing{
    private final List<ShapeCompenent> shapes;
    private final int height;
    private final int width;

    /**
     * Constructs a new drawing with no shape components and no dimensions.
     */
    Drawing(){
        shapes = new ArrayList<ShapeCompenent>();
        height = 0;
        width = 0;
    }

    /**
     * Constructs a new drawing with the specified dimensions and no shape components.
     *
     * @param width the width of the new drawing
     * @param height the height of the new drawing
     */
    Drawing(int width, int height){
        shapes = new ArrayList<ShapeCompenent>();
        this.height = height;
        this.width = width;
    }

    /**
     * Returns the height of this drawing.
     *
     * @return the height of this drawing
     */
    public int getHeight(){
        return height;
    }

    /**
     * Returns the width of this drawing.
     *
     * @return the width of this drawing
     */
    public int getWidth(){
        return width;
    }

    /**
     * Returns the shape components of this drawing.
     *
     * @return the shape components of this drawing
     */
    public List<ShapeCompenent> getShapes() {
        return Collections.unmodifiableList(shapes);
    }

    /**
     * Adds a shape component to this drawing.
     *
     * @param shape the shape component to add
     */
    public void addShape(ShapeCompenent shape){
        shapes.add(shape);
    }

    /**
     * Removes a shape component from this drawing.
     *
     * @param index the index of the shape component to remove
     */
    public void removeShape(int index){
        shapes.remove(index);
    }

    /**
     * Groups shape components in this drawing.
     *
     * @param indexes the indexes of the shape components to group
     */
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
     * Ungroups a shape group in this drawing.
     *
     * @param index the index of the shape group to ungroup
     * @return the size of the group, used in case of an undo
     */
    public int ungroup(int index){
        ShapeGroup group = (ShapeGroup) shapes.get(index);
        shapes.remove(index);
        shapes.addAll(group.getShapes());
        return group.getShapes().size();
    }

    /**
     * Sets the color of a shape component in this drawing.
     *
     * @param index the index of the shape component
     * @param newColor the new color for the shape component
     */
    public void setColor(int index, char newColor){
        shapes.get(index).setColor(newColor);
    }

    /**
     * Moves a shape component in this drawing.
     *
     * @param index the index of the shape component
     * @param dx the new x-coordinate for the shape component
     * @param dy the new y-coordinate for the shape component
     */
    public void moveShape(int index, double dx, double dy){
        shapes.get(index).move(dx, dy);
    }

    /**
     * Returns a shape component in this drawing that contains a specified point.
     *
     * @param p the point to check
     * @return the shape component that contains the point, or null if no such shape component exists
     */
    public ShapeCompenent getShape(Point p){
        for (ShapeCompenent s : shapes) {
            if (s.isInside(p)) {
                return s;
            }
        }
        return null;
    }

    /**
     * Sets a shape component in this drawing at a specified index, used only for undo.
     *
     * @param index the index at which to set the shape component
     * @param shape the shape component to set
     */
    public void SetIndexShape(int index, ShapeCompenent shape){
        shapes.add(index, shape);
    }
}