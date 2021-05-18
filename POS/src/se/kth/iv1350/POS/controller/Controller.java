package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.*;
import se.kth.iv1350.POS.util.ConsoleLogger;
import se.kth.iv1350.POS.util.Logger;
import se.kth.iv1350.POS.view.TotalRevenueView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller class that hands out tasks to appropriate classes.
 *
 */

public class Controller {
    SystemStartup systemStartUp;
    DiscountRules discountRules;
    Register register;
    Sale saleDetails;
    SalesLog salesLog;
    Printer printer;
    InventorySystem inventorySystem;
    ItemDTO latestScannedItemDTO;
    Logger logger;
    ConsoleLogger consoleLogger;
    private List<SaleObserver> saleObservers = new ArrayList<>();


    /**
     * Constructor creates all appropriate objets to run the application.
     */
    public Controller(Logger logger) throws IOException {
        this.discountRules = new DiscountRules(new DiscountFirstCase(), new DiscountSecondCase());
        this.systemStartUp = new SystemStartup();
        this.salesLog = new SalesLog(systemStartUp);
        this.inventorySystem = systemStartUp.getInventorySystem();
        this.printer = systemStartUp.getPrinter();
        this.register = systemStartUp.getRegister();
        this.logger = logger;
        consoleLogger = new ConsoleLogger(consoleLogger);
        salesLog.addSaleObserver(new TotalRevenueView());


    }

    /**
     * Creates a sales object and by that, starts a new salesprocess
     */
    public void initializeSale(){
        saleDetails = new Sale();

    }

    /**
     * adds item to the salesobject. If <code>quantity</code> is zero,
     * it will be replaced by quantity 1 as default.
     * also searched through inventorysystem and find matching item.
     * if item is already scanned it sums previous value and
     * new value into the quantity list
     *
     * @param identifier    each item has a individual identifier
     * @param quantity      quantity of items sold.
     * @return              updated instance of Sale object
     */
    public Sale scanItem(int identifier, int quantity) throws InvalidIdentifierException, OperationFailedException, IOException {
        if(isZero(quantity))
            quantity = 1;
        try{
        latestScannedItemDTO = inventorySystem.getDetails(identifier);
        }catch (DBFailureException dbFailureException){
            logger.log(dbFailureException.toString()+ "Cant connect to database");
            throw new OperationFailedException("error with current identifier: "+identifier, dbFailureException);

        }
        saleDetails.addItem(latestScannedItemDTO, quantity);

        return saleDetails;
    }


    private boolean isZero(int quantity) {
        return quantity == 0;
    }

    /**
     * ends the sales process
     *
     * @return  total price inc VAT.
     */
    public double endSale(){

        return saleDetails.getTotalPriceIncVat();
    }

    /**
     * Cashier requests discount and this will be the final step in the salesprocess
     *
     *
     * @param customerSSN   Customer identification number
     * @return              returns total price for the sale after discount
     */
    public double requestDiscount(long customerSSN){

        return discountRules.calculateDiscount(customerSSN, saleDetails);
    }

    /**
     * this method will calculate change to give back to custumer, creation of a receipts
     * logs the sale into saleslog and external systems
     * prints the receipt
     * @param amountPaid    amount that customer pays for the sale
     * @return              amount change (amountPaid - salesPrice)
     */
    public double calculateChange(double amountPaid){
        double amountChange = register.updateRegister(amountPaid, saleDetails);
        ReceiptDTO receiptDTO = new ReceiptDTO(amountPaid, amountChange, saleDetails);
        logsSaleAndPrintsReceipt(receiptDTO);


        return amountChange;
    }

    private void logsSaleAndPrintsReceipt(ReceiptDTO receiptDTO) {
        salesLog.logSale(receiptDTO);
        printer.printReceipt(receiptDTO);
    }



    /**
     * extracts the sales object from controller.
     *
     * @return sales object
     */
    public Sale getSaleDetails() {

        return saleDetails;
    }

    /**
     * Extracts attribute from the latest scanned item
     *
     * @return  latest scanned item
     */
    public ItemDTO getLatestItemDTO() {
        return latestScannedItemDTO;
    }

    /**
     * adds the spcified view to a list of observers. That should be observing
     * notified when a sale is completed
     *
     * @param totalRevenueView The view that should be added to the list
     */
    public void addSaleObserver(TotalRevenueView totalRevenueView) {
        saleObservers.add(totalRevenueView);
    }
}
