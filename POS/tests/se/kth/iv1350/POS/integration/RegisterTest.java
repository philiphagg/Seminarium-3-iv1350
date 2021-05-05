package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.model.Sale;

import static org.junit.jupiter.api.Assertions.*;

class RegisterTest {
    Register register;
    SystemStartup systemStartup;

    @BeforeEach
    void setUp() {
        SystemStartup systemStartup = new SystemStartup();
        this.register = systemStartup.getRegister();
    }

    @AfterEach
    void tearDown() {
        this.systemStartup = null;
        this.register = null;
    }

    @Test
    void testCreateRegister() {
        assertTrue(register instanceof Register, "register is not an instance of Register");
    }

    @Test
    void updateRegister() {
        double amountPaid = 100;
        Sale saleDetails = new Sale();
        saleDetails.setTotalPriceForSale(80);
        saleDetails.setTotalVatPrice(20);
        double amountChange = register.updateRegister(amountPaid, saleDetails);
        double expected = 0;
        assertEquals(expected,amountChange);


    }
}