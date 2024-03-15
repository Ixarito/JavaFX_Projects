package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.model.AsciiPaint;

public class CommandColor implements Command {

    private AsciiPaint paint;

    private int lastShapeIndex;
    private char lastColor;

    public CommandColor(AsciiPaint paint) {
        this.paint = paint;
    }

    @Override
    public void execute(String... parts) throws Exception {
        if (parts.length != 3) {
            throw new Exception("Parameters missing or to many parameters");
        }
        int shapeIndex = Integer.parseInt(parts[1]);
        char newColor = parts[2].charAt(0);
        //using of a temp color to prevent undefined behavior in case if the function setColor don't work
        char tempColor = paint.getShapes().get(shapeIndex).getColor();
        paint.setColor(shapeIndex, newColor);

        lastShapeIndex = shapeIndex;
        lastColor = tempColor;
    }

    @Override
    public void unexecute() {
        paint.setColor(lastShapeIndex, lastColor);
    }
}
