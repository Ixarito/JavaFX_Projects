package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.model.AsciiPaint;

public class CommandGroup implements Command {

    private AsciiPaint paint;

    private int lastGroupIndex;

    public CommandGroup(AsciiPaint paint) {
        this.paint = paint;
    }

    @Override
    public void execute(String... parts) throws Exception {
        int[] indexes = new int[parts.length - 1];
        for(int i = 0; i < indexes.length; i++){ // remove the -1 here
            indexes[i] = Integer.parseInt(parts[i+1]);
        }
        paint.group(indexes);
        lastGroupIndex = paint.getShapes().size()-1;
    }

    @Override
    public void unexecute() {
        paint.ungroup(lastGroupIndex);
    }
}
