package model;
import java.util.List;
import java.util.ArrayList;
public class Drawing{
    List<Shape> shapes;
    int height;
    int width;
    Drawing() {
        shapes = new ArrayList<Shape>();
    }
    Drawing(int width, int height) {
        this.width = width;
        this.height = height;
        shapes = new ArrayList<Shape>();
    }
}
