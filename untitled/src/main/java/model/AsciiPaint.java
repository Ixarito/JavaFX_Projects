package model;

public class AsciiPaint {
    Drawing drawing;

    AsciiPaint(){
        drawing = new Drawing();
    };

    AsciiPaint(int witdh, int height){
        drawing = new Drawing(witdh, height);
    };

    void newCircle(int x, int y, double radius, char color){
        drawing.addShape(new Circle(new Point(x, y), radius, color));
    }

    void newRectangle(int x, int y, double width, double height, char color){
        drawing.addShape(new Rectangle(new Point(x, y), width, height, color));
    }

    void newSquare(int x, int y, int side, char color){
        drawing.addShape(new Square(new Point(x, y), side, color));
    }

}
