package g60453.atl.ascii.controller;

import g60453.atl.ascii.model.AsciiPaint;

import java.util.ArrayList;
import java.util.Scanner;

import g60453.atl.ascii.view.View;

public class Application {



    public void exit(){
        System.exit(0);
    }

    void start() {
        View.welcome();
        Scanner scanner = new Scanner(System.in);
        AsciiPaint paint;

        while (true){
            System.out.println("Enter the width and the heigh of the drawing like this : 16 9");
            String command = scanner.nextLine().toLowerCase();
            String[] parts = command.split(" ");
            try {
                if (parts.length != 2){
                    throw new Exception("Parameters missing or to many parameters");
                }
                int width = Integer.parseInt(parts[0]);
                int height = Integer.parseInt(parts[1]);
                paint = new AsciiPaint(width, height);
                View.gridSuccess();
                break;
            } catch (Exception e){
                View.errorInCommand();
            }
        }

        //only a test
        paint.newCircle(5, 5, 3, 'r');
        paint.newRectangle(1, 1, 5, 3, 'b');
        paint.newSquare(10, 10, 4, 'g');
        paint.newCircle(10, 10, 2, 'y');
        paint.group(0, 1, 2);
        paint.group(0, 1);
        paint.ungroup(0);


        while (true) {

            View.shell();
            String command = scanner.nextLine().toLowerCase();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "add":
                    try {

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
                        paint.moveShape(index, dx, dy);
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
                case "exit", "alt+f4":
                    View.exit();
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
        ArrayList<String> list = new ArrayList<String>();
        app.start();
    }
}