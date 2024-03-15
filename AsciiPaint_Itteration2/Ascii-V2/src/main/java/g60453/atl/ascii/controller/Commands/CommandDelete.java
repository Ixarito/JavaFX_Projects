package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.model.AsciiPaint;
import g60453.atl.ascii.model.ShapeCompenent;

public class CommandDelete implements Command{

    private AsciiPaint paint;
    private int lastShapeIndex;
    private ShapeCompenent lastRemovedShape;

    public CommandDelete(AsciiPaint paint){
        this.paint = paint;
    }

    @Override
    public void execute(String... parts) throws Exception {
        if (parts.length != 2) {
            throw new Exception("Parameters missing or to many parameters");
        }
        int index = Integer.parseInt(parts[1]);
        //using of a temp shape to prevent undefined behavior in case if the function removeShape don't work
        ShapeCompenent tempShape = paint.getShapes().get(index);
        paint.removeShape(index);

        lastShapeIndex = index;
        lastRemovedShape = tempShape;

    }

    @Override
    public void unexecute() {
        paint.SetIndexShape(lastShapeIndex, lastRemovedShape);
    }
}
