package se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.*;

import static org.junit.jupiter.api.Assertions.*;


class SalesLogTest {
    Controller controller;
    SystemStartup systemStartup;
    SalesLog salesLog;

    @BeforeEach
    void setUp() {
        systemStartup = new SystemStartup();
        controller = new Controller();
        salesLog = new SalesLog(systemStartup);
    }

    @AfterEach
    void tearDown() {
        controller = null;
    }

    @Test
    void logSaleLogsReceipt() throws InvalidIdentifierException, OperationFailedException {
        controller.initializeSale();
        Sale saleDetails = controller.scanItem(1,1);
        ReceiptDTO receiptDTO = new ReceiptDTO(100,10,saleDetails);
        salesLog.logSale(receiptDTO);
        int actual = salesLog.getSalesLog().size();
        int expected = 1;
        assertEquals(expected,actual,"Receipt wasn't added to Sales log");



    }
}