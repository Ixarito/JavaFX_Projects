package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.model.AsciiPaint;

public class CommandUngroup implements Command {

    private AsciiPaint paint;

    private int lastGroupSize;

    public CommandUngroup(AsciiPaint paint) {
        this.paint = paint;
    }

    @Override
    public void execute(String... parts) throws Exception {
        if (parts.length != 2) {
            throw new Exception("Parameters missing or to many parameters");
        }
        lastGroupSize = paint.ungroup(Integer.parseInt(parts[1]));
    }

    @Override
    public void unexecute() {
        int lastShape = paint.getShapes().size() - 1;
        int[] indexes = new int[lastGroupSize];
        for (int i = 0; i < lastGroupSize; i++) {
            indexes[i] = lastShape - i;
        }
        paint.group(indexes);
    }
}
