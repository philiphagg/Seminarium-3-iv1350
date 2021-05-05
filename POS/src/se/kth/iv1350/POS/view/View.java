package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.model.Sale;

public class View  {
    Controller controller;

    public View(){
        this.controller = new Controller();
    }
    public void initializeSale(){
        controller.initializeSale();
        System.out.println("A new sale has been started");
    }

    public void scanItem(int identifier, int quantity){

        Sale saleDetails = controller.scanItem(identifier, quantity);
        ItemDTO recentlyScannedItemDTO = recentScannedItem(saleDetails);
        System.out.println("-------------------------->");
        System.out.println("Running total ex VAT: " + saleDetails.getTotalPriceForSale());
        System.out.println("Running total inc VAT: " + saleDetails.getTotalPriceIncVat());
        System.out.println("Last item scanned: " +recentlyScannedItemDTO.getItemName());
        System.out.println("Item Description: " + recentlyScannedItemDTO.getItemDescription() );
        System.out.println("Item Price: " + recentlyScannedItemDTO.getItemPrice());
        System.out.println("<--------------------------");
    }

    private ItemDTO recentScannedItem(Sale saleDetails) {
        return saleDetails.getItemListInSale().get(lastIndex(saleDetails));
    }

    private int lastIndex(Sale saleDetails) {
        return saleDetails.getItemListInSale().size() - 1;
    }

    public void endSale(){
        double totalPriceIncVat = controller.endSale();
        System.out.println("-------------------------->");
        System.out.println("sale finished");
        System.out.println("Total Price inc VAT: " + totalPriceIncVat);
        System.out.println("<--------------------------");
    }
    public void enterAmountPaid(double amountPaid){

        double amountChange = controller.calculateChange(amountPaid);
        System.out.println("-------------------------->");
        System.out.println("Amount change after payment: " + amountChange);
        System.out.println("<--------------------------");
    }
    public void requestDiscount(long custumerSSN){
        double totalPriceAfterDiscount = controller.requestDiscount(custumerSSN);
        System.out.println("-------------------------->");
        System.out.println("Total price after discount: " +totalPriceAfterDiscount);
        System.out.println("<--------------------------");
    }
    public void runFakeExecution(){
        initializeSale();
        scanItem(2,1);
        scanItem(3,3);
        endSale();
        enterAmountPaid(250);
    }

}
