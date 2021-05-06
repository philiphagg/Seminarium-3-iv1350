package se.kth.iv1350.POS.startup;


import se.kth.iv1350.POS.view.View;

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
    public static void main(String[] args) {
        View view = new View();
        view.runFakeExecution();
    }

}

