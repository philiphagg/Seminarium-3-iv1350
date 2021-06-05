package se.kth.iv1350.POS.model;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.POS.integration.*;

public class SalesLog {
    ArrayList<ReceiptDTO> salesLog;
    AccountingSystem accountingSystem;
    InventorySystem inventorySystem;
    TotalRevenueFileOutput totalRevenueFileOutput;
    private List<SaleObserver> saleObservers = new ArrayList<>();
    private UpdateExternalSystems updateExternalSystems;
    ExternalSystemsFactory externalSystemsFactory;




    /**
     * initiates sales log and getting references to appropriate systems.
     *
     * @param systemStartup
     */
    public SalesLog(SystemStartup systemStartup) throws IOException {
        accountingSystem = systemStartup.getAccountingSystem();
        inventorySystem = systemStartup.getInventorySystem();
        salesLog = new ArrayList<>();
        this.totalRevenueFileOutput = new TotalRevenueFileOutput();
        this.updateExternalSystems = systemStartup.getUIS();



    }

    /**
     * logs sale into saleslog, accountingsystem and inventorysystem.
     *
     * @param receiptDTO    receiptDTO contains more information than a sale
     *                      therefore I choosed to log the receipt that contains
     *                      all availiable information about each sale
     */
    public void logSale(ReceiptDTO receiptDTO)  {
        addSaleToSalesLog(receiptDTO);
        notifyObservers(receiptDTO);
        this.externalSystemsFactory = new ExternalSystemsFactory();
        updateExternalSystems.updateSystem(receiptDTO);


    }

    private void notifyObservers(ReceiptDTO receiptDTO) {
        for (SaleObserver saleObs : saleObservers){
            saleObs.saleFinished(receiptDTO.getSaleDetails().getTotalPriceIncVat());
        }
    }

    /**
     * adds the specified observer to the list of observers
     *
     * @param saleObserver  the specified observer added to the list
     */
    public void addSaleObserver(SaleObserver saleObserver){
        saleObservers.add(saleObserver);
    }

    /**
     * Adds the specified list of observers added to the list
     *
     * @param saleObservers the list of observers added to the list
     */
    public void addSaleObservers(List<SaleObserver> saleObservers){
        saleObservers.addAll(saleObservers);
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
