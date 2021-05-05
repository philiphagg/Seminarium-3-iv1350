package se.kth.iv1350.POS.model;
import java.util.ArrayList;

import se.kth.iv1350.POS.integration.AccountingSystem;
import se.kth.iv1350.POS.integration.InventorySystem;
import se.kth.iv1350.POS.integration.ReceiptDTO;
import se.kth.iv1350.POS.integration.SystemStartup;

public class SalesLog {
    ArrayList<ReceiptDTO> salesLog;
    AccountingSystem accountingSystem;
    InventorySystem inventorySystem;

    /**
     * initiates sales log and getting references to appropriate systems.
     *
     * @param systemStartup
     */
    public SalesLog(SystemStartup systemStartup) {
        accountingSystem = systemStartup.getAccountingSystem();
        inventorySystem = systemStartup.getInventorySystem();
        salesLog = new ArrayList<>();
    }

    /**
     * logs sale into saleslog, accountingsystem and inventorysystem.
     *
     * @param receiptDTO    receiptDTO contains more information than a sale
     *                      therefore I choosed to log the receipt that contains
     *                      all availiable information about each sale
     */
    public void logSale(ReceiptDTO receiptDTO){
        addSaleToSalesLog(receiptDTO);
        accountingSystem.updateAccountingSystem(receiptDTO);
        inventorySystem.updateInventorySystem(receiptDTO);

    }


    private void addSaleToSalesLog(ReceiptDTO receiptDTO){
        salesLog.add(receiptDTO);
    }

    /**
     * Extracts attribute from Sales log object
     *
     * @return current sales log.
     */
    public ArrayList<ReceiptDTO> getSalesLog() {
        return salesLog;
    }
}
