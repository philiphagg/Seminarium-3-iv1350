package se.kth.iv1350.POS.integration;

/**
 * Contains the exception thrown when database can't be reached.
 * extends RuntimeException because it's a unchecked exception
 */

public class DBFailureException extends RuntimeException{

    /**
     * creates a new instance of the <code>DBFailureException</code> with
     * specified message
     *
     * @param message the detail message.
     */
    public DBFailureException(String message) {
        super(message);
    }
}
