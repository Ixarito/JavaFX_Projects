package Controller;

import model.AsciiPaint;

public class Application {
    AsciiPaint paint;

    void start() {
    }
    public static void main(String[] args) {
        //test draw a square
        AsciiPaint paint = new AsciiPaint(10, 10);
        paint.newSquare(1, 1, 5, 'x');
        paint.getDrawing().shellDrawAllShapes();
    }

}
