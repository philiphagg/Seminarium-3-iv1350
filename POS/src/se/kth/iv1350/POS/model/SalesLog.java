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
     * creates a new sales log instance
     */
    public SalesLog(SystemStartup systemStartup) {
        accountingSystem = systemStartup.getAccountingSystem();
        inventorySystem = systemStartup.getInventorySystem();
        salesLog = new ArrayList<>();
    }

    /**
     * logs sale into saleslog, accountingsystem and inventorysystem.
     * @param receiptDTO
     */
    public void logSale(ReceiptDTO receiptDTO){
        addSaleToSalesLog(receiptDTO);
        accountingSystem.updateAccountingSystem(receiptDTO);
        inventorySystem.updateInventorySystem(receiptDTO);

    }

    /**
     * logs a receipt inside the saleslog. The receipt includes all available information
     * about each sale.
     * @param receiptDTO
     */
    private void addSaleToSalesLog(ReceiptDTO receiptDTO){
        salesLog.add(receiptDTO);
    }

    public ArrayList<ReceiptDTO> getSalesLog() {
        return salesLog;
    }
}
