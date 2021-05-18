package se.kth.iv1350.POS.util;

import java.io.IOException;

/**
 * this interface is reponsible for logging. interface enables
 * other classes to create instances of more than one type of loggers
 * without changing a lot of code.
 */
public interface Logger {

    void log(String message) throws IOException;
}
