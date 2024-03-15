package g60453.atl.ascii.controller.Commands;

import g60453.atl.ascii.controller.Exceptions.InvalidCommandException;

import java.util.HashMap;
import java.util.Stack;

/**
 * Manages the execution, undoing, and redoing of commands.
 */
public class CommandManager{

    private final HashMap<String, Command> commandMap = new HashMap<>();
    private Stack<Command> executedCommands = new Stack<>();
    private Stack<Command> undoneCommands = new Stack<>();

    /**
     * Registers a command with a given name.
     *
     * @param commandName the name of the command
     * @param command the command to register
     */
    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }

    /**
     * Executes a command with the given name and arguments.
     *
     * @param commandName the name of the command to execute
     * @param args the arguments to pass to the command
     * @throws InvalidCommandException if an error occurs during command execution
     */
    public void execute(String commandName, String... args) throws InvalidCommandException {
        Command command = commandMap.get(commandName);
        command.execute(args);
        executedCommands.push(command);
        // Clear the undoneCommands stack when a new command is executed
        undoneCommands.clear();
    }

    /**
     * Undoes the last executed command.
     */
    public void undo() {
        if (!executedCommands.isEmpty()) {
            Command lastCommand = executedCommands.pop();
            lastCommand.unexecute();
            undoneCommands.push(lastCommand);
        }
    }

    //Redo not implemented
}