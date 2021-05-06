package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.model.Sale;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * not included for seminar 3
 */
class InventorySystemTest {
    SystemStartup systemStartup;
    InventorySystem inventorySystem;
    private ItemDTO itemDTO;

    @BeforeEach
    void setUp() {
        systemStartup = new SystemStartup();
        inventorySystem = systemStartup.getInventorySystem();
    }

    @AfterEach
    void tearDown() {
        systemStartup = null;
        inventorySystem = null;
    }


    @Test
    void getDetailsCreatesItemDTOCorrectly() {

        itemDTO = inventorySystem.getDetails(3);
        String expectedItemName = "bröd";
        String actual = itemDTO.getItemName();
        assertEquals(expectedItemName,actual, "Expected item didn't add to sale object");
    }

}