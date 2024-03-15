package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.controller.Exceptions.InvalidCommandException;
import g60453.atl.ascii.model.AsciiPaint;
import g60453.atl.ascii.model.ShapeCompenent;
import g60453.atl.ascii.view.View;

public class CommandAdd implements Command {

    private AsciiPaint paint;

    private int lastShapeIndex;

    public CommandAdd(AsciiPaint paint) {
        this.paint = paint;
    }

    @Override
    public void execute(String... parts) throws InvalidCommandException {
        switch (parts[1]) {
            case "circle" -> {
                if (parts.length != 6) {
                    throw new InvalidCommandException("Parameters missing or to many parameters");
                }
                int x = Integer.parseInt(parts[2]);
                int y = Integer.parseInt(parts[3]);
                double radius = Double.parseDouble(parts[4]);
                char color = parts[5].charAt(0);
                paint.newCircle(x, y, radius, color);
            }
            case "rectangle" -> {
                if (parts.length != 7) {
                    throw new InvalidCommandException("Parameters missing or to many parameters");
                }
                int x = Integer.parseInt(parts[2]);
                int y = Integer.parseInt(parts[3]);
                double width = Double.parseDouble(parts[4]);
                double height = Double.parseDouble(parts[5]);
                char color = parts[6].charAt(0);
                paint.newRectangle(x, y, width, height, color);
            }
            case "square" -> {
                if (parts.length != 6) {
                    throw new InvalidCommandException("Parameters missing or to many parameters");
                }
                int x = Integer.parseInt(parts[2]);
                int y = Integer.parseInt(parts[3]);
                double side = Double.parseDouble(parts[4]);
                char color = parts[5].charAt(0);
                paint.newSquare(x, y, side, color);
            }
            default -> {
                View.errorInCommand();
                throw new InvalidCommandException("Invalid shape");
            }
        }

        lastShapeIndex = paint.getShapes().size()-1;
    }

    @Override
    public void unexecute() {
        paint.removeShape(lastShapeIndex);
    }

}
