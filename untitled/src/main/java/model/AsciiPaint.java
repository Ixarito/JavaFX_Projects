package model;

public class AsciiPaint {
    Drawing drawing;

    AsciiPaint(){
        drawing = new Drawing();
    };

    AsciiPaint(int witdh, int height){
        drawing = new Drawing(witdh, height);
    };

    void newCircle(int x, int y, int radius, char color){
    }

    void newRectangle(int x, int y, int width, int height, char color){
    }

    void newSquare(int x, int y, int side, char color){
    }

}
