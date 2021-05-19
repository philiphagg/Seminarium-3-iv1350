package se.kth.iv1350.POS.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.integration.InvalidIdentifierException;
import se.kth.iv1350.POS.integration.OperationFailedException;
import se.kth.iv1350.POS.integration.Register;
import se.kth.iv1350.POS.integration.SystemStartup;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.SaleObserver;
import se.kth.iv1350.POS.util.FileLogger;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller controller;
    Sale saleDetails;


    @BeforeEach
    void setUp() throws IOException {
        this.controller = new Controller(new FileLogger());
    }

    @AfterEach
    void tearDown() {
        this.controller = null;
    }

    @Test
    void testIfInitializeSaleCreatesSaleObject() {
        controller.initializeSale();
        assertNotNull(controller.saleDetails, "Controllers sale objekt is not created");
    }

    @Test
    void controllerIsCreated(){
        assertNotNull(controller);
    }

    @Test
    void scanItemFindscorrectItem() throws InvalidIdentifierException, OperationFailedException, IOException {
        controller.initializeSale();
        saleDetails = controller.scanItem(3,2);
        String expectedItemName = "bröd";
        String actual = saleDetails.getItemListInSale().get(0).getItemName();
        assertEquals(expectedItemName,actual, "Expected item didn't add to sale object");
    }
    @Test
    void scanItemZeroQty() throws InvalidIdentifierException, OperationFailedException, IOException {
        controller.initializeSale();
        saleDetails = controller.scanItem(1,0);
        int numberOfItemsInSale = saleDetails.getItemListInSale().size();
        int expectedItemsInSale = 1;
        assertEquals(expectedItemsInSale,numberOfItemsInSale, "zero items was added.");

    }
    @Test
    void testScanItemAddsItem() throws InvalidIdentifierException, OperationFailedException, IOException {
        controller.initializeSale();
        saleDetails = controller.scanItem(1,1);

        int numberOfItemsInSale = saleDetails.getItemListInSale().size();
        int expectedItemsInSale = 1;
        assertEquals(expectedItemsInSale,numberOfItemsInSale, "Items was not added");
    }
    @Test
    void testScanItemAddsQty() throws InvalidIdentifierException, OperationFailedException, IOException {
        controller.initializeSale();
        saleDetails = controller.scanItem(1,2);

        int numberOfItemsInSale = saleDetails.getTotalItemQuantityInSale();
        int expectedItemsInSale = 2;
        assertEquals(expectedItemsInSale,numberOfItemsInSale, "Quantity was not added to the sale");
    }

    @Test
    void endSale() {
        Sale saleDetails = new Sale();
        double totalPrice = 10;
        double totalVAT = 2.5;
        saleDetails.setTotalPriceForSale(totalPrice);
        saleDetails.setTotalVatPrice(totalVAT);
        double runningTotalIncVat = saleDetails.getTotalPriceIncVat();
        double expected = totalPrice + totalVAT;
        assertEquals(expected,runningTotalIncVat,"did not return expected value");
    }

    @Test
    void requestDiscount() {
        /**
         * was not included in seminar 3, left blanc on purpose
         */
    }

    @Test
    void calculateChange() {
        Sale saleDetails = new Sale();
        saleDetails.setTotalPriceForSale(70);
        saleDetails.setTotalVatPrice(10);
        SystemStartup systemStartup = new SystemStartup();
        Register register = systemStartup.getRegister();
        double testAmountPaid = 100;
        double expected = testAmountPaid - saleDetails.getTotalPriceIncVat();
        double testAmountChange = register.updateRegister(testAmountPaid, saleDetails);
        assertEquals(expected, testAmountChange,"did not calculate change as expected");
    }





    @Test
    void testCalculateChangePrintReceipt(){

    }
    @Test
    void testReturnsChange() throws InvalidIdentifierException, OperationFailedException, IOException {
        controller.initializeSale();
        controller.scanItem(1,1);
        double actual = controller.calculateChange(12.5);
        int expected = 0;
        assertEquals(expected,actual, "Did not calculate change as expected");
    }

    @Test
    void testCalculateChangeLogsSale(){
        controller.initializeSale();
        controller.calculateChange(100);
        int actual = controller.salesLog.getSalesLog().size();
        int expected = 1;
        assertEquals(expected,actual);

    }
    @Test
    void testOperationFailedException(){
        OperationFailedException operationFailedException = assertThrows(
                OperationFailedException.class, () -> controller.scanItem(5,1) , "Did not throw expected exception"
        );

        assertTrue(operationFailedException.getMessage().contains("error with current identifier"), "Did not throw expected exception");
    }

    @Test
    void addSaleObserver(){

    }

}