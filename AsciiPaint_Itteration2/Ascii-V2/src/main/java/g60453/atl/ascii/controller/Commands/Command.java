package g60453.atl.ascii.controller.Commands;

public interface Command {
    public void execute(String... parts) throws Exception;
    public void unexecute();
}
