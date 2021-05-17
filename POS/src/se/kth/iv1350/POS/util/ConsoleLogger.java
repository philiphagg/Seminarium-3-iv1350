package se.kth.iv1350.POS.util;

public class ConsoleLogger implements Logger{
    ConsoleLogger consoleLogger;

    public ConsoleLogger(ConsoleLogger consoleLgr) {
        consoleLogger = consoleLgr;
    }

    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
