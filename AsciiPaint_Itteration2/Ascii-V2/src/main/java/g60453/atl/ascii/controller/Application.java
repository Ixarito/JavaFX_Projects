package g60453.atl.ascii.controller;

import g60453.atl.ascii.controller.Commands.*;
import g60453.atl.ascii.model.AsciiPaint;

import java.util.ArrayList;
import java.util.Scanner;

import g60453.atl.ascii.view.View;

public class Application {


    void start() {
        AsciiPaint paint;
        View.welcome();
        Scanner scanner = new Scanner(System.in);



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

        //Initialisation of commands
        CommandManager MyCommandManager = new CommandManager();
        MyCommandManager.register("add", new CommandAdd(paint));
        MyCommandManager.register("move", new CommandMove(paint));
        MyCommandManager.register("color", new CommandColor(paint));
        MyCommandManager.register("delete", new CommandDelete(paint));
        MyCommandManager.register("group", new CommandGroup(paint));
        MyCommandManager.register("ungroup", new CommandUngroup(paint));
        MyCommandManager.register("delete", new CommandDelete(paint));

        paint.newCircle(5, 5, 3, 'o');
        paint.newRectangle(10, 10, 5, 5, 'x');
        paint.newSquare(2, 2, 3, 'y');
        paint.group(0, 1);

        //AsciiPaint Loop
        while (true) {

            View.shell();
            String command = scanner.nextLine().toLowerCase();
            String[] parts = command.split(" ");
            try {
                switch (parts[0]) {
                    case "add" -> {
                        MyCommandManager.execute("add", parts);
                        View.addSuccess();
                    }
                    case "show" -> View.printDrawing(paint.asAscii());

                    case "list" -> View.printShapeList(paint.getShapesString());

                    case "move" -> {
                        MyCommandManager.execute("move", parts);
                        View.moveSuccess();
                    }
                    case "color" -> {
                        MyCommandManager.execute("color", parts);
                        View.colorSuccess();
                    }
                    case "group" -> {
                        MyCommandManager.execute("group", parts);
                        View.groupSuccess();
                    }
                    case "ungroup" -> {
                        MyCommandManager.execute("ungroup", parts);
                        View.ungroupSuccess();
                    }
                    case "delete" -> {
                        MyCommandManager.execute("delete", parts);
                        View.removeSuccess();
                    }
                    case "exit", "alt+f4" -> {
                        View.exit();
                        return;
                    }
                    case "help" -> View.help();

                    case "undo" -> MyCommandManager.undo();
                    case "redo"-> MyCommandManager.redo();
                    default -> View.unknownCommand();
                }
            } catch (Exception e) {
                View.errorInCommand();
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        ArrayList<String> list = new ArrayList<String>();
        app.start();
    }
}