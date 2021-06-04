package se.kth.iv1350.POS.integration;


import org.junit.jupiter.api.*;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.SalesLog;
import se.kth.iv1350.POS.util.FileLogger;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * this test will be added for additional higher grade task
 *
 */

class PrinterTest {
    Controller controller;
    private ByteArrayOutputStream printBuffer;
    private PrintStream originalPrint;
    SystemStartup systemStartup;
    Printer printer;

    @BeforeEach
    void setUp() throws IOException {
        controller = new Controller(new FileLogger());
        this.systemStartup = new SystemStartup();
        this.printer = systemStartup.getPrinter();
        changeStreamOut();
    }

    @AfterEach
    void tearDown() {
        controller = null;
        systemStartup = null;
        printer = null;
        restoreStreamOutput();
    }

    @Test
    void printReceipt() {
        controller.initializeSale();

        Sale saleDetails = controller.getSaleDetails();
        ReceiptDTO receiptDTO = new ReceiptDTO(100,10,saleDetails);
        printer.printReceipt(receiptDTO);
        String printOut = this.printBuffer.toString();
        String expected = "RECEIPT";
        assertTrue(printOut.contains(expected),"Receipt was not printed as expected");
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