package g60453.atl.ascii.controller.Commands;
import java.util.HashMap;

public class CommandManager{

    private final HashMap<String, Command> commandMap = new HashMap<>();

    public void register(String commandName, Command command) {
        commandMap.put(commandName, command);
    }


    public void execute(String cmdName) {
        Command command = commandMap.get(cmdName);
        if (command == null) {
            throw new IllegalStateException("no command registered for " + cmdName);
        }
        command.execute();
    }
}
