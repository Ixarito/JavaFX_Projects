package model;

public class Square extends Rectangle {
    Square(Point upperLeft, double side, char color) {
        super(upperLeft, side, side, color);
    }

    public String toString() {
        return "Square";
    }
}
