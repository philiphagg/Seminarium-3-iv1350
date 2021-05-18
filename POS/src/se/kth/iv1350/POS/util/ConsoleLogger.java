package se.kth.iv1350.POS.util;


/**
 * logger responsible of writing logs to the console.
 */
public class ConsoleLogger implements Logger{
    ConsoleLogger consoleLogger;

    /**
     * Creates an instance of consoleLogger
     *
     * @param consoleLgr    ConsoleLogger
     */
    public ConsoleLogger(ConsoleLogger consoleLgr) {
        consoleLogger = consoleLgr;
    }

    /**
     * Prints the specified message to the console
     *
     * @param message   message that shall be printed
     */
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
