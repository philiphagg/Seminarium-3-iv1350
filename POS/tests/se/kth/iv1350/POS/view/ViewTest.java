package se.kth.iv1350.POS.view;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    Controller controller;
    @BeforeEach
    void setUp() {
        this.controller = new Controller();
    }

    @AfterEach
    void tearDown() {
        this.controller = null;
    }

    @Test
    void testInitializeSaleIfItsCorrectInstance() {
        controller.initializeSale();
        assertTrue(controller.getSaleDetails() instanceof Sale, "Controllers SaleObject is not an instance of Sale");


    }

    @Test
    void scanItem() {
    }

    @Test
    void endSale() {
    }

    @Test
    void enterAmountPaid() {
    }

    @Test
    void requestDiscount() {
    }
}