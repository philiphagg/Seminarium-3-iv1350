package se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.util.FileLogger;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    Sale saleDetails;
    Controller controller;
    SystemStartup systemStartup;
    InventorySystem inventorySystem;


    @BeforeEach
    void setUp() throws IOException {
        this.saleDetails = new Sale();
        this.controller = new Controller(new FileLogger());
        this.systemStartup = new SystemStartup();
        this.inventorySystem = systemStartup.getInventorySystem();
    }

    @AfterEach
    void tearDown() {
        this.saleDetails = null;
    }

    @Test
    void saleInstanceOf(){
        assertNotNull(saleDetails);
    }

    @Test
    void addItemToSale() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,1);
        int actual = saleDetails.getItemListInSale().size();
        int expected = 1;
        assertEquals(expected,actual,"no item was added to Sale");
    }
    @Test
    void addQuantityToSale() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        int actual = saleDetails.getItemQuantityListInSale().size();
        int expected = 1;
        assertEquals(expected,actual,"no quantity was added to Sale");
    }
    @Test
    void addTotalPriceForSale() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        double actual = saleDetails.getTotalPriceForSale();
        double expected = 20;
        assertEquals(expected,actual,"total price for sale wasn't calculated correctly");
    }
    @Test
    void addVatPrice() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        double actual = saleDetails.getTotalVatPrice();
        double expected = 10*.25+10*.25;
        assertEquals(expected,actual,"total vat price for sale wasn't calculated correctly");

    }
    @Test
    void addTotalItemQuantity() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        double actual = saleDetails.getTotalItemQuantityInSale();
        double expected = 2;
        assertEquals(expected,actual,"item quantity didn't add correctly");
    }

    @Test
    void addItemAlreadyScanned() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,1);
        saleDetails.addItem(itemDTO,1);
        int actual = saleDetails.getItemListInSale().size();
        int expected = 1;
        assertEquals(expected,actual,"no item was added to Sale");
    }
    @Test
    void addItemAlreadyScannedCheckQuantityList() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        saleDetails.addItem(itemDTO,3);
        int actual = saleDetails.getItemQuantityListInSale().get(0);
        int expected = 5;
        assertEquals(expected,actual,"quantity did not calculate correctly after scanning same item");
    }
    @Test
    void addItemAlreadyScannedTotalQuantity() throws InvalidIdentifierException, DBFailureException {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        saleDetails.addItem(itemDTO,3);
        int actual = saleDetails.getTotalItemQuantityInSale();
        int expected = 5;
        assertEquals(expected,actual,"quantity did not calculate correctly after scanning same item");
    }

    @Test
    void getItemDetailsThrowsInvalidIdentifierException() throws InvalidIdentifierException, DBFailureException {

        ItemDTO itemDTO = inventorySystem.getDetails(10);
        InvalidIdentifierException invalidIdentifierException = assertThrows(
                InvalidIdentifierException.class, () -> saleDetails.addItem(itemDTO, 1), "Did not throw expected exception"
        );

        assertTrue(invalidIdentifierException.getMessage().contains("identifier is invalid:"), "Did not throw expected exception");
    }


}