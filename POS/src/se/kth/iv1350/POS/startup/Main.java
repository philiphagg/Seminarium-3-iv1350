package se.kth.iv1350.POS.startup;



import se.kth.iv1350.POS.integration.InvalidIdentifierException;
import se.kth.iv1350.POS.view.View;
import java.io.IOException;

/**
 * Class responsible for booting the application.
 */

public class Main {


    /**
     * Main method that boots application. Starts up the view and runs a
     * fake execution to demonstrate the application.
     *
     * @param args  array of command line arguments
     */
    public static void main(String[] args) throws IOException, InvalidIdentifierException {
        System.out.println("System has been started");
        View view = new View();
        view.runFakeExecution();
        view.runFakeExecution();

    }

}

