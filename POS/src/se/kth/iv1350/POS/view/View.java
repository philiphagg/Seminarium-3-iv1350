package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.Controller;
import se.kth.iv1350.POS.integration.InvalidIdentifierException;
import se.kth.iv1350.POS.integration.ItemDTO;
import se.kth.iv1350.POS.integration.OperationFailedException;
import se.kth.iv1350.POS.model.Sale;
import se.kth.iv1350.POS.util.FileLogger;

import java.io.IOException;

public class View   {
    Controller controller;
    Sale saleDetails;


    public View() throws IOException {
        this.controller = new Controller(new FileLogger());
        controller.addSaleObserver(new TotalRevenueView());



    }


    private void initializeSale(){
        controller.initializeSale();
        System.out.println("A new sale has been started");
    }

    private void scanItem(int identifier, int quantity)  {

        try {
            saleDetails = controller.scanItem(identifier, quantity);
        }catch(InvalidIdentifierException invalidIdentifierException){
            System.out.println("identifier you're trying to scan is invalid: identifier " +identifier);
            return;
        }catch(OperationFailedException operationFailedException){
            System.out.println("Something went wrong -> " +operationFailedException);
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
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
    private void enterAmountPaid(double amountPaid) throws IOException {

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
    public void runFakeExecution() throws InvalidIdentifierException, IOException {
        initializeSale();
        scanItem(2,1);
        scanItem(10,1); //invalid identifier
        scanItem(3,3);
        scanItem(5,1); // identifier that causes db failure
        requestDiscount(3L);
        endSale();
        enterAmountPaid(250);
    }

}
