package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.controller.Exceptions.InvalidCommandException;

/**
 * Represents a command that can be executed and undone.
 */
public interface Command {

    /**
     * Executes the command with the given arguments.
     *
     * @param parts the arguments to pass to the command
     * @throws Exception if an error occurs during command execution
     */
    public void execute(String... parts) throws InvalidCommandException;

    /**
     * Undoes the command.
     */
    public void unexecute();
}