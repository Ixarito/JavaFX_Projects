package View;

import model.Drawing;

public class View {

    private View() {
    }

    public static void help() {
        System.out.println("1.Add => Add a shape \n" +
                "2. Show => Show the drawing \n" +
                "3. List => List all shapes \n" +
                "4. Move => Move a shape \n" +
                "5. Change => Change the color of a shape \n" +
                "6. Exit => Exit the program \n" +
                "7. Help => You know what it does");
    }

    public static void printShapeList(String shape) {
        System.out.println(shape);
    }

    public static void printDrawing(String drawing) {
        if (drawing.isEmpty()) {
            System.out.println("\u001B[38;5;51mNo drawing to show \u001B[0m");
            return;
        }
        System.out.println(drawing);
    }

    public static void errorInCommand() {
        System.out.println("\u001B[38;5;196mError in the command\u001B[0m");
    }

    public static void unknowCommand() {
        System.out.println("\u001B[38;5;196mCommand unrecognized\u001B[0m");
    }

    public static void genericError() {
        System.out.println("\u001B[38;5;196mAn error occurred\u001B[0m");
    }


    public static void unknownCommand() {
        System.out.println("Unknown command");
    }

    public static void list() {
        System.out.println("List of shapes : ");
    }

    public static void addSuccess() {
        System.out.println("Shape added successfully");
    }
    public static void moveSuccess() {
        System.out.println("Shape moved successfully");
    }

    public static void colorSuccess() {
        System.out.println("Color changed successfully");
    }

    public static void removeSuccess() {
        System.out.println("Shape removed successfully");
    }

    public static void quit() {
        System.out.println("shutting down...");
    }


}
