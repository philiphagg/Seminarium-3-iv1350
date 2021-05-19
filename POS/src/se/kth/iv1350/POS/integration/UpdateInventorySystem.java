package se.kth.iv1350.POS.integration;

/**
 * contains the logic updating the external inventory system
 */
public class UpdateInventorySystem implements UpdateExternalSystems {
    SystemStartup systemStartup;
    InventorySystem inventorySystem;

    /**
     * creates a new instance
     */
    public UpdateInventorySystem() {
    }

    /**
     * Creates a new instance and assigns a systemstartup to parameter
     * and assigns the inventory system from systemstartup
     *
     * @param systemStartup the object holding the system startup
     */
    public UpdateInventorySystem(SystemStartup systemStartup) {
        this.systemStartup = systemStartup;
        this.inventorySystem = systemStartup.getInventorySystem();
    }

    /**
     * updates the external inventory system
     *
     * @param receiptDTO the object holding all information about each sale
     */
    @Override
    public void updateSystem(ReceiptDTO receiptDTO) {
        inventorySystem.updateInventorySystem(receiptDTO);
    }


}
