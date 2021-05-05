package se.kth.iv1350.POS.integration;


import se.kth.iv1350.POS.model.Sale;

public class Printer {
    Printer() {
    }

    public void printReceipt(ReceiptDTO receiptDTO){

        System.out.println("-------------------------->");
        System.out.println("----RECEIPT----");
        System.out.println("STORE NAME: " +receiptDTO.getStoreName());
        System.out.print("STREET: " + receiptDTO.getStoreStreet());
        System.out.println(" NO: " +receiptDTO.getStoreStreetNo());
        System.out.println("CITY: " +receiptDTO.getStoreCity());
        System.out.println();
        System.out.println("TIME: " + receiptDTO.getDateTime());
        System.out.println("TOTAL PRICE INC VAT: " + receiptDTO.getSaleDetails().getTotalPriceIncVat());
        System.out.println("TOTAL VAT PRICE: " + receiptDTO.getSaleDetails().getTotalVatPrice());
        System.out.println("CHANGE: " + receiptDTO.getAmountChange());
        System.out.println("PAID: " + receiptDTO.getAmountPaid());
            for(int i = 0; i < receiptDTO.getSaleDetails().getItemQuantityListInSale().size(); i++){
                System.out.print("Item: "+receiptDTO.getSaleDetails().getItemListInSale().get(i).getItemName());
                System.out.print("\tPrice: " +receiptDTO.getSaleDetails().getItemListInSale().get(i).getItemPrice());
                System.out.println("\tQuantity: " +receiptDTO.getSaleDetails().getItemQuantityListInSale().get(i).toString());
            }
        System.out.println("<--------------------------");


    }
}
