package se.kth.iv1350.POS.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.InvalidIdentifierException;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    private ByteArrayOutputStream printBuffer;
    private PrintStream originalPrint;
    View view;


    @AfterEach
    void tearDown() {
        restoreStreamOutput();
        view = null;
    }

    @BeforeEach
    void setUp() throws IOException {
        changeStreamOut();
        view = new View();
    }


    @Test
    void runFakeExecutionInitializeSale() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "A new sale has been started";
        assertTrue(printOut.contains(expected),"print out failed.");
    }
    @Test
    void runFakeExecutionScanItemPrint() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "Running total ex VAT";
        assertTrue(printOut.contains(expected),"print out failed.");
    }
    @Test
    void runFakeExecutionEndSale() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "sale finished";
        assertTrue(printOut.contains(expected),"print out failed.");
    }
    @Test
    void runFakeExecutionEnterAmountPaid() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "Amount change after payment:";
        assertTrue(printOut.contains(expected),"print out failed.");
    }

    @Test
    void runFakeExecutionRequestDiscount() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "Total price after discount:";
        assertTrue(printOut.contains(expected),"print out failed.");
    }
    @Test
    void runFakeExecutionExceptionTestInvalidIdentifierSystemOut() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "identifier you're trying to scan is invalid: identifier";
        assertTrue(printOut.contains(expected),"print out failed.");
    }
    @Test
    void runFakeExecutionExceptionOperationFailedSystemOut() throws InvalidIdentifierException, IOException {
        view.runFakeExecution();
        String printOut = this.printBuffer.toString();
        String expected = "Something went wrong ->";
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