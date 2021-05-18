package se.kth.iv1350.POS.integration;


/**
 * Exception that notifies the user about the <code>DBFailureException</code>
 * when an unchecked exception is caught.
 */
public class OperationFailedException extends Exception {

    /**
     * Constructs a new runtime exception with the specified detail message.
     *
     * @param message   the detail message.
     * @param cause     the exception that was originally thrown
     */
    public OperationFailedException(String message, Exception cause) {
        super(message, cause);
    }
}
