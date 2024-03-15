package g60453.atl.ascii.model;

import java.util.ArrayList;
import java.util.List;
/**
 * Represents an ASCII paint application for the model.
 */
public class AsciiPaint {
    private final Drawing drawing;

    /**
     * Constructs a new ASCII paint application with no dimensions.
     */
    AsciiPaint(){
        drawing = new Drawing();

    }

    /**
     * Constructs a new ASCII paint application with the specified dimensions.
     *
     * @param width the width of the new ASCII paint application
     * @param height the height of the new ASCII paint application
     */
    public AsciiPaint(int witdh, int height){
        drawing = new Drawing(witdh, height);

    }

    /**
     * Draws the shapes in this ASCII paint application.
     *
     * @return a string representation of the shapes in this ASCII paint application
     */
    public String asAscii(){
        StringBuilder output = new StringBuilder();
        for (int y = 0; y < drawing.getHeight(); y++){
            for (int x = 0; x < drawing.getWidth(); x++){
                Point p = new Point(x, y);
                if (drawing.getShape(p) != null){
                    output.append(" \u001B[38;5;46m").append(drawing.getShape(p).getColor()).append(" \u001B[0m");
                } else {
                    output.append("\u001B[38;5;8m · \u001B[0m");
                }
            }
            output.append("\n");
        }
        return output.toString();
    }

    /**
     * Returns under form of text the shapes in this ASCII paint application, used for showing the shapes list.
     *
     * @return a string representation of the shapes in this ASCII paint application
     */
    public String getShapesString(){
        StringBuilder output = new StringBuilder();
        List<ShapeCompenent> shapes = drawing.getShapes();
        for (int i = 0; i < shapes.size(); i++){
            output.append(i).append(". ").append(shapes.get(i).toString()).append("\n");
        }
        if (shapes.size() == 0){
            return null;
        }
        return output.toString();
    }

    /**
     * Returns a string representation of this ASCII paint application.
     *
     * @return a string representation of this ASCII paint application
     */
    public List<ShapeCompenent> getShapes(){
        return drawing.getShapes();
    }

    /**
     * Adds a new circle to this ASCII paint application.
     *
     * @param x the x-coordinate of the new circle
     * @param y the y-coordinate of the new circle
     * @param radius the radius of the new circle
     * @param color the color of the new circle
     */
    public void newCircle(int x, int y, double radius, char color){
        drawing.addShape(new ShapeLeaf(new Circle(new Point(x, y), radius, color)));
    }

    /**
     * Adds a new rectangle to this ASCII paint application.
     *
     * @param x the x-coordinate of the new rectangle
     * @param y the y-coordinate of the new rectangle
     * @param width the width of the new rectangle
     * @param height the height of the new rectangle
     * @param color the color of the new rectangle
     */
    public void newRectangle(int x, int y, double width, double height, char color){
        drawing.addShape(new ShapeLeaf(new Rectangle(new Point(x, y), width, height, color)));
    }

    /**
     * Adds a new square to this ASCII paint application.
     *
     * @param x the x-coordinate of the new square
     * @param y the y-coordinate of the new square
     * @param side the side length of the new square
     * @param color the color of the new square
     */
    public void newSquare(int x, int y, double side, char color){
        drawing.addShape(new ShapeLeaf(new Square(new Point(x, y), side, color)));
    }

    /**
     * Removes a shape from this ASCII paint application.
     *
     * @param index the index of the shape to remove
     */
    public void removeShape(int index){
        drawing.removeShape(index);
    }

    /**
     * Sets the color of a shape in this ASCII paint application.
     *
     * @param index the index of the shape
     * @param newColor the new color for the shape
     */
    public void setColor(int index, char newColor){
        drawing.setColor(index, newColor);
    }

    /**
     * Moves a shape in this ASCII paint application.
     *
     * @param index the index of the shape
     * @param dx the new x-coordinate for the shape
     * @param dy the new y-coordinate for the shape
     */
    public void moveShape(int index, double dx, double dy){
        drawing.moveShape(index, dx, dy);
    }

    /**
     * Groups shapes in this ASCII paint application.
     *
     * @param indexes the indexes of the shapes to group
     */
    public void group(int... indexes){
        drawing.group(indexes);
    }

    /**
     * Ungroups a shape group in this ASCII paint application.
     *
     * @param index the index of the shape group to ungroup
     * @return the size of the group, used in case of an undo
     */
    public int ungroup(int index){
        return drawing.ungroup(index);
    }

    /**
     * Sets a shape in this ASCII paint application at a specified index, used only for undo.
     *
     * @param index the index at which to set the shape
     * @param shape the shape to set
     */
    public void SetIndexShape(int index, ShapeCompenent shape){
        drawing.SetIndexShape(index, shape);
    }
}
