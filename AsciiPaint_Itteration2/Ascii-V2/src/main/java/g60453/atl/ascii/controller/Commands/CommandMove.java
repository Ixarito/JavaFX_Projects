package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.model.AsciiPaint;

public class CommandMove implements Command {

    private AsciiPaint paint;
    private double lastShapeX;
    private double lastShapeY;
    private int lastShapeIndex;


    public CommandMove(AsciiPaint paint) {
        this.paint = paint;
    }

    @Override
    public void execute(String... parts) throws Exception {
        int index = Integer.parseInt(parts[1]);
        double dx = Double.parseDouble(parts[2]);
        double dy = Double.parseDouble(parts[3]);
        double tempX = paint.getShapes().get(index).getPoint().getX();
        double tempY = paint.getShapes().get(index).getPoint().getY();
        paint.moveShape(index, dx, dy);
        lastShapeX = tempX;
        lastShapeY = tempY;
        lastShapeIndex = index;
    }

    @Override
    public void unexecute() {
        paint.moveShape(lastShapeIndex, lastShapeX, lastShapeY);
    }


}
