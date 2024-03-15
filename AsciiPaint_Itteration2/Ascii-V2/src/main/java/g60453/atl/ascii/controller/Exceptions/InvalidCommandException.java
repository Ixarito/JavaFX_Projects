package g60453.atl.ascii.controller.Exceptions;

/**
 * Represents an exception that is thrown when an invalid command is entered.
 */
public class InvalidCommandException extends Exception {

    /**
     * Constructs a new InvalidCommandException with the specified detail message.
     *
     * @param message the detail message
     */
    public InvalidCommandException(String message) {
        super(message);
    }
}