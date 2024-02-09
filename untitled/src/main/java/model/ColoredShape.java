package model;

public abstract class ColoredShape implements Shape {
    char color;

    ColoredShape(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }


}
