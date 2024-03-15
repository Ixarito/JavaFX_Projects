package g60453.atl.ascii.view;

public class View {

    private View() {}

    public static void help() {
        String helpMessage = "\u001B[38;5;51mCOMMANDS:\u001B[0m\n" +
                "\u001B[38;5;46m. Add [shape] [parameters]\u001B[0m => Add a shape to the drawing. Parameters depend on the shape.\n" +
                "\u001B[38;5;46m    - Circle [x] [y] [radius] [color]\u001B[0m => Add a circle. x and y are the coordinates of the center, radius is the radius of the circle, color is the color of the circle.\n" +
                "\u001B[38;5;46m    - Rectangle [x] [y] [width] [height] [color]\u001B[0m => Add a rectangle. x and y are the coordinates of the upper left corner, width and height are the dimensions of the rectangle, color is the color of the rectangle.\n" +
                "\u001B[38;5;46m    - Square [x] [y] [side] [color]\u001B[0m => Add a square. x and y are the coordinates of the upper left corner, side is the length of the side of the square, color is the color of the square.\n" +
                "\u001B[38;5;46m. Show\u001B[0m => Display the current state of the drawing\n" +
                "\u001B[38;5;46m. List\u001B[0m => List all shapes in the drawing\n" +
                "\u001B[38;5;46m. Move [index] [dx] [dy]\u001B[0m => Move a shape in the drawing. Index is the shape's position in the list, dx and dy are the displacement in x and y directions respectively.\n" +
                "\u001B[38;5;46m. Color [index] [color]\u001B[0m => Change the color of a shape in the drawing. Index is the shape's position in the list, color is the new color.\n" +
                "\u001B[38;5;46m. Group [index1] [index2] ... [indexN]\u001B[0m => Group shapes in the drawing. Indexes are the positions of the shapes in the list.\n" +
                "\u001B[38;5;46m. Ungroup [index]\u001B[0m => Ungroup a group of shapes in the drawing. Index is the position of the group in the list.\n" +
                "\u001B[38;5;46m. Delete [index]\u001B[0m => Delete a shape from the drawing. Index is the shape's position in the list.\n" +
                "\u001B[38;5;46m. Undo\u001B[0m => Undo the last command\n" +
                "\u001B[38;5;46m. Exit\u001B[0m => Exit the program\n" +
                "\u001B[38;5;46m. Help\u001B[0m => Display this help message\n";

        System.out.println(helpMessage);
    }

    public static void welcome() {
        //welcome message in ascii art
        System.out.println(
                "\u001B[38;5;51m _       __     __              \n" +
                "| |     / /__  / /________  ____ ___  ___\n" +
                "| | /| / / _ \\/ / ___/ __ \\/ __ `__ \\/ _ \\\n" +
                "| |/ |/ /  __/ / /__/ /_/ / / / / / /  __/\n" +
                "|__/|__/\\___/_/\\___/\\____/_/ /_/ /_/\\___/\n" +
                "\n                In AsciiPaint                    \u001B[0m\n");
    }

    public static void shell() {
        System.out.print("\u001B[38;5;46mAsciiPaint> \u001B[0m");
    }

    public static void printShapeList(String shape) {
        if (shape == null) {
            System.out.println("\u001B[38;5;196mNo shapes to show\u001B[0m");
            return;
        }
        System.out.println(shape);
    }

    public static void printDrawing(String drawing) {

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

    public static void displayError(String errorMessage) {
        System.out.println("\u001B[38;5;196m" + errorMessage + "\u001B[0m");
    }

    public static void unknownCommand() {
        System.out.println("\u001B[38;5;196mUnknown command\u001B[0m");
    }

    public static void list() {
        System.out.println("List of shapes : ");
    }

    public static void addSuccess() {
        System.out.println("\u001B[38;5;51mShape added successfully\u001B[0m");
    }
    public static void moveSuccess() {
        System.out.println("\u001B[38;5;51mShape moved successfully\u001B[0m");
    }

    public static void gridSuccess() {
        System.out.println("\u001B[38;5;51mGrid created successfully, use \u001B[38;5;46mhelp\u001B[38;5;51m to know commands\u001B[0m");
    }

    public static void colorSuccess() {
        System.out.println("\u001B[38;5;51mColor changed successfully\u001B[0m");
    }

    public static void removeSuccess() {
        System.out.println("\u001B[38;5;51mShape removed successfully\u001B[0m");
    }

    public static void groupSuccess() {
        System.out.println("\u001B[38;5;51mShapes grouped successfully\u001B[0m");
    }

    public static void ungroupSuccess() {
        System.out.println("\u001B[38;5;51mShapes ungrouped successfully\u001B[0m");
    }


    public static void exit() {
        System.out.println("\u001B[38;5;196mshutting down...\u001B[0m");
    }


}
