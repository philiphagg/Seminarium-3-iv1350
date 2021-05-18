package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.integration.ItemDTO;

/**
 * second algorithm that gives discount if customer has bought a specific item
 */
public class DiscountSecondCase implements DiscountEligability{
    String specificItem = "bulle";

    /**
     * Algorithm that calculates discount if customer has purchased a specifik item
     *
     * @param custumerSSN   customer identification
     * @param saleDetails   information about the sale
     */
    @Override
    public void calculateDiscount(long custumerSSN, Sale saleDetails) {

        for(ItemDTO item : saleDetails.getItemListInSale())
            if(itemFound(specificItem, item)){
                saleDetails.setTotalPriceForSale(saleDetails.getTotalPriceForSale() *0.5);
            }
    }

    private boolean itemFound(String specificItem, ItemDTO item) {
        return item.getItemName().equals(specificItem);
    }
}
