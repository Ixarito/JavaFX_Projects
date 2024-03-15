package g60453.atl.ascii.model;

import java.util.ArrayList;
import java.util.List;

public class AsciiPaint {
    private final Drawing drawing;

    AsciiPaint(){
        drawing = new Drawing();

    };
    public AsciiPaint(int witdh, int height){
        drawing = new Drawing(witdh, height);

    }

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

    public List<ShapeCompenent> getShapes(){
        return drawing.getShapes();
    }

    public void newCircle(int x, int y, double radius, char color){
        drawing.addShape(new ShapeLeaf(new Circle(new Point(x, y), radius, color)));
    }

    public void newRectangle(int x, int y, double width, double height, char color){
        drawing.addShape(new ShapeLeaf(new Rectangle(new Point(x, y), width, height, color)));
    }

    public void newSquare(int x, int y, double side, char color){
        drawing.addShape(new ShapeLeaf(new Square(new Point(x, y), side, color)));
    }

    public void removeShape(int index){
        drawing.removeShape(index);
    }

    public void setColor(int index, char newColor){
        drawing.setColor(index, newColor);
    }

    public void moveShape(int index, double dx, double dy){
        drawing.moveShape(index, dx, dy);
    }

    public void group(int... indexes){
        drawing.group(indexes);
    }

    public int ungroup(int index){
        return drawing.ungroup(index);
    }

    public void SetIndexShape(int index, ShapeCompenent shape){
        drawing.SetIndexShape(index, shape);
    }
}
