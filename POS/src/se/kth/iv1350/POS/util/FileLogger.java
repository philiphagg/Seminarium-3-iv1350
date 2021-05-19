package se.kth.iv1350.POS.util;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;


/**
 * class responsible for logging to files
 */
public class FileLogger implements Logger {
    String fileLocation = "POS/src/se/kth/iv1350/POS/util/ExceptionLog.txt";

    PrintWriter printWriter;

    /**
     * creates a new instance of the <code>FileLogger</code> and assigns
     * a new <code>PrintWriter</code> with hardcoded file location.
     *
     * @throws IOException is thrown
     */
    public FileLogger() throws IOException {
    printWriter = new PrintWriter(fileLocation);
    }

    /**
     * creates a new instance of the <code>FileLogger</code> and assigns
     * a new <code>PrintWriter</code> with specified file location
     *
     * @param fileLocation              the specified file location
     * @throws FileNotFoundException    if the file cannot be found
     */
    public FileLogger(String fileLocation) throws FileNotFoundException {
        printWriter = new PrintWriter(fileLocation);
    }

    /**
     * this method logs to file, with a timestamp and a specified message
     * flushes the stream and closes the stream
     *
     * @param message   the specified message
     */
    @Override
    public void log(String message)  {
        printWriter.println(currentTime()+ ": " +message);
        System.out.println();
        printWriter.flush();

    }


    private LocalDateTime currentTime(){
        return LocalDateTime.now();
    }
}
