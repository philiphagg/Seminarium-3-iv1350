package se.kth.iv1350.POS.controller;

import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.DiscountRules;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.model.SalesLog;


public class Controller {
    SystemStartup systemStartUp;
    DiscountRules discountRules;
    Register register;
    Sale saleDetails;
    SalesLog salesLog;
    Printer printer;
    InventorySystem inventorySystem;

    /**
     * Constructor creates objects for <code>discountRules</code>
     */
    public Controller() {
        this.discountRules = new DiscountRules();
        this.systemStartUp = new SystemStartup();
        this.salesLog = new SalesLog(systemStartUp);
        this.inventorySystem = systemStartUp.getInventorySystem();
        this.printer = systemStartUp.getPrinter();
        this.register = systemStartUp.getRegister();

    }

    /**
     * Creates a sales object and by that, starts a new salesprocess
     */
    public void initializeSale(){
        saleDetails = new Sale();

    }

    /**
     * adds item to the salesobject.
     * @param identifier
     * @param quantity
     * @return
     */
    public Sale scanItem(int identifier, int quantity){
        if(isZero(quantity))
            quantity = 1;

        ItemDTO itemDTO = inventorySystem.getDetails(identifier);

        if(isValid(itemDTO)){
            saleDetails.addItem(itemDTO, quantity);
        }else{
            invalidIdentifierMessage();
        }


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
     * updates the register - creates a receipt - logs the sale in the sales log and
     * prints the receipt.
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
        salesLog.logSale(receiptDTO);
        printer.printReceipt(receiptDTO);


        return amountChange;
    }

    /**
     * checks if a item is registered in the inventory-system.
     * @param itemDTO
     * @return  <code>true</code> if item is valid for scan <code>false</code> if item is not found in inventorysystem.
     */
    private boolean isValid(ItemDTO itemDTO){

        return controlValidItemDescription(itemDTO);
    }
    private boolean controlValidItemDescription(ItemDTO itemDTO){
        return itemDTO.getItemDescription() != "Invalid identifier";
    }


    private void invalidIdentifierMessage(){
        System.out.println("Item you're trying to scan is not yet in the inventory system");
    }

    public Sale getSaleDetails() {
        return saleDetails;
    }
}
