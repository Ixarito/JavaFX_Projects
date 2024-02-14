package model;
import java.util.List;
import java.util.ArrayList;
public class Drawing{
    List<Shape> shapes;
    int height;
    int width;

    Drawing(){
        shapes = new ArrayList<Shape>();
        height = 0;
        width = 0;
    }

    Drawing(int width, int height){
        shapes = new ArrayList<Shape>();
        this.height = height;
        this.width = width;
    }

    public void addShape(Shape shape){
        shapes.add(shape);
    }

    public Shape getShape(Point p){
        for (Shape s : shapes) {
            if (s.isInside(p)) {
                return s;
            }
        }
        return null;
    }

    int getHeight(){
        return height;
    }
    int getWidth(){
        return width;
    }
}
