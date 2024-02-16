package Controller;

import model.AsciiPaint;

import java.util.Scanner;

import View.View;
import model.Point;

public class Application {

    AsciiPaint paint = new AsciiPaint(30, 20);


    void start() {
        Scanner scanner = new Scanner(System.in);


        while (true) {
            String command = scanner.nextLine().toLowerCase();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "add":
                    try {
                        if (parts[1].equals("circle")) {
                            if (parts.length != 6) {
                                throw new Exception("Parameters missing or to many parameters");
                            }
                            int x = Integer.parseInt(parts[2]);
                            int y = Integer.parseInt(parts[3]);
                            double radius = Double.parseDouble(parts[4]);
                            char color = parts[5].charAt(0);
                            paint.newCircle(x, y, radius, color);
                        } else if (parts[1].equals("rectangle")) {
                            if (parts.length != 7) {
                                throw new Exception("Parameters missing or to many parameters");
                            }
                            int x = Integer.parseInt(parts[2]);
                            int y = Integer.parseInt(parts[3]);
                            double width = Double.parseDouble(parts[4]);
                            double height = Double.parseDouble(parts[5]);
                            char color = parts[6].charAt(0);
                            paint.newRectangle(x, y, width, height, color);
                        } else if (parts[1].equals("square")) {
                            if (parts.length != 6) {
                                throw new Exception("Parameters missing or to many parameters");
                            }
                            int x = Integer.parseInt(parts[2]);
                            int y = Integer.parseInt(parts[3]);
                            double side = Double.parseDouble(parts[4]);
                            char color = parts[5].charAt(0);
                            paint.newSquare(x, y, side, color);
                        } else {
                            View.errorInCommand();
                            break;
                        }
                    } catch (Exception e) {
                        View.errorInCommand();
                        break;
                    }
                    View.addSuccess();
                    break;
                case "show":
                    try {
                        if (parts.length != 1) {
                            View.errorInCommand();
                            break;
                        }
                        View.printDrawing(paint.asAscii());
                    } catch (Exception e) {
                        View.genericError();
                    }
                    break;
                case "list":
                    try {
                        if (parts.length != 1) {
                            View.errorInCommand();
                            break;
                        }
                        View.printShapeList(paint.getShapesString());
                    } catch (Exception e) {
                        View.genericError();
                    }
                    break;
                case "move":
                    try {
                        int index = Integer.parseInt(parts[1]);
                        double dx = Double.parseDouble(parts[2]);
                        double dy = Double.parseDouble(parts[3]);
                        View.moveSuccess();
                    } catch (Exception e) {
                        View.errorInCommand();
                        break;
                    }
                    View.moveSuccess();
                    break;
                case "color":
                    try {
                        if (parts.length != 3) {
                            throw new Exception("Parameters missing or to many parameters");
                        }
                        int shapeIndex = Integer.parseInt(parts[1]);
                        char newColor = parts[2].charAt(0);
                        paint.setColor(shapeIndex, newColor);
                    } catch (Exception e) {
                        View.errorInCommand();
                        break;
                    }
                    View.colorSuccess();
                    break;
                case "remove":
                    try {
                        if (parts.length != 2) {
                            throw new Exception("Parameters missing or to many parameters");
                        }
                        int index = Integer.parseInt(parts[1]);
                        paint.removeShape(index);
                    } catch (Exception e) {
                        View.errorInCommand();
                        break;
                    }
                    View.removeSuccess();
                    break;
                case "exit", "quit", "Alt+F4" :
                    return;
                case "help":
                    View.help();
                    break;
                default:
                    View.unknownCommand();
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}