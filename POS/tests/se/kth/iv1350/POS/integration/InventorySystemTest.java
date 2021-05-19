package se.kth.iv1350.POS.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


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
    void getDetailsCreatesItemDTOCorrectly() throws DBFailureException {

        itemDTO = inventorySystem.getDetails(3);
        String expectedItemName = "bröd";
        String actual = itemDTO.getItemName();
        assertEquals(expectedItemName,actual, "Expected item didn't add to sale object");
    }
    @Test
    void getItemDetailsThrowsFailureDBReachException() throws DBFailureException{
        int identifier = 5;
        DBFailureException dbFailureException = assertThrows(
                DBFailureException.class, () -> inventorySystem.getDetails(identifier), "Did not throw expected exception"
        );

        assertTrue(dbFailureException.getMessage().contains("error code: 125454213"), "Did not throw expected exception");
    }

}