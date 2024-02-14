package model;

public class AsciiPaint {
    Drawing drawing;

    AsciiPaint(){
        drawing = new Drawing();
    };

    public AsciiPaint(int witdh, int height){
        drawing = new Drawing(witdh, height);
    };

    public void newCircle(int x, int y, double radius, char color){
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    public void newRectangle(int x, int y, double width, double height, char color){
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    public void newSquare(int x, int y, int side, char color){
        drawing.addShape(new Square(new Point(x, y), side, color));
    }

    public Drawing getDrawing() {
        return drawing;
    }
}
