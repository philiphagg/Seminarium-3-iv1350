package se.kth.iv1350.POS.integration;

/**
 * Contains the exception thrown when an identifier that is
 * not in the inventorysystem. Extends exceptions because it's
 * a checked exception.
 */

public class InvalidIdentifierException extends Exception {

    /**
     * Constructs a new exception with the specified detail message.
     *
     * @param message the detail message.
     */
    public InvalidIdentifierException(String message) {
        super(message);
    }
}
