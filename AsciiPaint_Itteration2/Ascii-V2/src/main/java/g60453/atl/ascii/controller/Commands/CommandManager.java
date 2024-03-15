package g60453.atl.ascii.controller.Commands;
import java.util.HashMap;
import java.util.Stack;

public class CommandManager{

    private final HashMap<String, Command> commandMap = new HashMap<>();
    private Stack<Command> executedCommands = new Stack<>();
    private Stack<Command> undoneCommands = new Stack<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }


    public void execute(String commandName, String... args) throws Exception {
        Command command = commandMap.get(commandName);
        command.execute(args);
        executedCommands.push(command);
        // Clear the undoneCommands stack when a new command is executed
        undoneCommands.clear();
    }

    public void undo() {
        if (!executedCommands.isEmpty()) {
            Command lastCommand = executedCommands.pop();
            lastCommand.unexecute();
            undoneCommands.push(lastCommand);
        }
    }





}
