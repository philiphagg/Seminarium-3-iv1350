package se.kth.iv1350.POS.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    Controller controller;
    View view;
    @BeforeEach
    void setUp() {
        this.view = new View();
        this.controller = new Controller();
    }

    @AfterEach
    void tearDown() {

        this.controller = null;
    }

    @Test
    void testInitializeSaleIfItsCorrectInstance() {
        controller.initializeSale();
        Sale saledetails = controller.getSaleDetails();
        saledetails.setTotalPriceForSale(100);
        assertTrue(saledetails instanceof Sale, "Controllers SaleObject is not an instance of Sale");


    }

    @Test
    void scanItemReceivesSale() {
        controller.initializeSale();
        Sale saleDetails = controller.scanItem(1,2);
        int actual = saleDetails.getItemListInSale().size();
        int expected = 1;
        assertEquals(expected,actual, "Did not return sale correctly");
    }


    @Test
    void endSale() {
        controller.initializeSale();
        controller.scanItem(1,2);
        double actual = controller.endSale();
        double expected = 12.5*2;
        assertEquals(expected,actual,"did not return exoected total price including vat");

    }

    @Test
    void enterAmountPaid() {
        controller.initializeSale();
        controller.scanItem(1,2);
        double actual = controller.calculateChange(100);
        double expected = 100-12.5*2;
        assertEquals(expected,actual,"Did not return the expected amount of change");


    }

    @Test
    void requestDiscount() {
        /**
         * not included in seminar 3
         */
    }
}