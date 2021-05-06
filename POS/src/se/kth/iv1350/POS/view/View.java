package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.model.Sale;

public class View  {
    Controller controller;

    public View(){

        this.controller = new Controller();
    }


    private void initializeSale(){
        controller.initializeSale();
        System.out.println("A new sale has been started");
    }

    private void scanItem(int identifier, int quantity){

        Sale saleDetails = controller.scanItem(identifier, quantity);
        ItemDTO recentlyScannedItemDTO = recentScannedItem();
        System.out.println("-------------------------->");
        System.out.println("Running total ex VAT: " + saleDetails.getTotalPriceForSale());
        System.out.println("Running total inc VAT: " + saleDetails.getTotalPriceIncVat());
        System.out.println("Last item scanned: " +recentlyScannedItemDTO.getItemName());
        System.out.println("Item Description: " + recentlyScannedItemDTO.getItemDescription() );
        System.out.println("Item Price: " + recentlyScannedItemDTO.getItemPrice());
        System.out.println("<--------------------------");
    }

    private ItemDTO recentScannedItem() {
        return controller.getLatestItemDTO();
    }


    private void endSale(){
        double totalPriceIncVat = controller.endSale();
        System.out.println("-------------------------->");
        System.out.println("sale finished");
        System.out.println("Total Price inc VAT: " + totalPriceIncVat);
        System.out.println("<--------------------------");
    }
    private void enterAmountPaid(double amountPaid){

        double amountChange = controller.calculateChange(amountPaid);
        System.out.println("-------------------------->");
        System.out.println("Amount change after payment: " + amountChange);
        System.out.println("<--------------------------");
    }
    private void requestDiscount(long custumerSSN){
        double totalPriceAfterDiscount = controller.requestDiscount(custumerSSN);
        System.out.println("-------------------------->");
        System.out.println("Total price after discount: " +totalPriceAfterDiscount);
        System.out.println("<--------------------------");
    }

    /**
     * Method that runs a fake execution of the program.
     * that is not a part of the program but simulates expected output
     * of function calls.
     *
     */
    public void runFakeExecution(){
        initializeSale();
        scanItem(2,1);
        scanItem(1,1);
        scanItem(2,3);
        endSale();
        enterAmountPaid(250);
    }

}
