package se.kth.iv1350.POS.startup;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.InvalidIdentifierException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * should not be tested for seminar 3.
 */

class MainTest {
    private ByteArrayOutputStream printBuffer;
    private PrintStream originalPrint;


    @BeforeEach
    void setUp() {
        changeStreamOut();
    }

    @AfterEach
    void tearDown() {
        restoreStreamOutput();
    }

    @Test
    void mainSystemOut() throws IOException, InvalidIdentifierException {
        String[] args = null;
        Main.main(args);
        String printOut = this.printBuffer.toString();
        String expected = "System has been started";
        assertTrue(printOut.contains(expected),"print out failed.");
    }

    private void changeStreamOut(){
        printBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printBuffer);
        originalPrint = System.out;
        System.setOut(inMemSysOut);
    }
    private void restoreStreamOutput(){
        printBuffer = null;
        System.setOut(originalPrint);

    }

}
