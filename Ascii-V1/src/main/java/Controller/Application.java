package Controller;

import model.AsciiPaint;

import java.util.Scanner;

public class Application {

    void start() {
        Scanner scanner = new Scanner(System.in);
        AsciiPaint paint = new AsciiPaint(30, 20);

        while (true) {
            String command = scanner.nextLine();
            String[] parts = command.split(" ");
            switch (parts[0]) {
                case "add":
                    if (parts[1].equals("circle")) {
                        int x = Integer.parseInt(parts[2]);
                        int y = Integer.parseInt(parts[3]);
                        double radius = Double.parseDouble(parts[4]);
                        char color = parts[5].charAt(0);
                        paint.newCircle(x, y, radius, color);

                    } else if (parts[1].equals("rectangle")) {
                        int x = Integer.parseInt(parts[2]);
                        int y = Integer.parseInt(parts[3]);
                        double width = Double.parseDouble(parts[4]);
                        double height = Double.parseDouble(parts[5]);
                        char color = parts[6].charAt(0);
                        paint.newRectangle(x, y, width, height, color);

                    } else if (parts[1].equals("square")) {
                        int x = Integer.parseInt(parts[2]);
                        int y = Integer.parseInt(parts[3]);
                        double side = Double.parseDouble(parts[4]);
                        char color = parts[5].charAt(0);
                        paint.newSquare(x, y, side, color);
                    }
                    break;
                case "show":
                    paint.getDrawing().shellDrawAllShapes();
                    break;
                case "list":
                    // Ici, vous devez implémenter la logique pour afficher la liste des formes.
                    break;
                case "move":
                    int index = Integer.parseInt(parts[1]);
                    double dx = Double.parseDouble(parts[2]);
                    double dy = Double.parseDouble(parts[3]);
                    // Ici, vous devez implémenter la logique pour déplacer la forme à l'index spécifié.
                    break;
                case "color":
                    int shapeIndex = Integer.parseInt(parts[1]);
                    char newColor = parts[2].charAt(0);
                    // Ici, vous devez implémenter la logique pour changer la couleur de la forme à l'index spécifié.
                    break;
                default:
                    System.out.println("Commande non reconnue.");
            }
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();

    }
}