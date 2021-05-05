package se.kth.iv1350.POS.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.integration.SystemStartup;

import static org.junit.jupiter.api.Assertions.*;

class SaleTest {
    Sale saleDetails;
    Controller controller;
    SystemStartup systemStartup;
    InventorySystem inventorySystem;


    @BeforeEach
    void setUp() {
        this.saleDetails = new Sale();
        this.controller = new Controller();
        this.systemStartup = new SystemStartup();
        this.inventorySystem = systemStartup.getInventorySystem();
    }

    @AfterEach
    void tearDown() {
        this.saleDetails = null;
    }

    @Test
    void saleInstanceOf(){
        assertTrue(saleDetails instanceof Sale);
    }

    @Test
    void addItemToSale() {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,1);
        int actual = saleDetails.getItemListInSale().size();
        int expected = 1;
        assertEquals(expected,actual,"no item was added to Sale");
    }
    @Test
    void addQuantityToSale() {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        int actual = saleDetails.getItemQuantityListInSale().size();
        int expected = 1;
        assertEquals(expected,actual,"no quantity was added to Sale");
    }
    @Test
    void addTotalPriceForSale() {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        double actual = saleDetails.getTotalPriceForSale();
        double expected = 20;
        assertEquals(expected,actual,"total price for sale wasn't calculated correctly");
    }
    @Test
    void addVatPrice() {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        double actual = saleDetails.getTotalVatPrice();
        double expected = 10*.25+10*.25;
        assertEquals(expected,actual,"total vat price for sale wasn't calculated correctly");

    }
    @Test
    void addTotalItemQuantity() {
        ItemDTO itemDTO = inventorySystem.getDetails(1);
        saleDetails.addItem(itemDTO,2);
        double actual = saleDetails.getTotalItemQuantityInSale();
        double expected = 2;
        assertEquals(expected,actual,"item quantity didn't add correctly");
    }

}