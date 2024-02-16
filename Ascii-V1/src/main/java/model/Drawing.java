package model;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
public class Drawing{
    private final List<Shape> shapes;
    private final int height;
    private final int width;

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

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public List<Shape> getShapes() {
        return Collections.unmodifiableList(shapes);
    }


    public void addShape(Shape shape){
        shapes.add(shape);
    }


    public void removeShape(int index){
        shapes.remove(index);
    }

    public void setColor(int index, char newColor){
        shapes.get(index).setColor(newColor);
    }


    public void moveShape(int index, double dx, double dy){
        shapes.get(index).move(dx, dy);
    }


    public Shape getShape(Point p){
        for (Shape s : shapes) {
            if (s.isInside(p)) {
                return s;
            }
        }
        return null;
    }

    public void draw(){
        for (int i = 0; i < height; i++){
            for (int j = 0; j < width; j++){
                Point p = new Point(i, j);
                if (getShape(p) != null){
                    System.out.print(" " + getShape(p).getColor() + " ");
                } else {
                    System.out.print("   ");
                }
            }
            System.out.println();
        }
    }
}
