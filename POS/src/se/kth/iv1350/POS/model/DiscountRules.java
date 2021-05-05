package se.kth.iv1350.POS.model;


/**
 * Class that handles discounts and rules based on information about the customer and
 * the current sale.
 * Simple calculation demonstrated although it was not included in seminar 3.
 */

public class DiscountRules {
    private int numberOfItemBought;
    private int identfier; // item bought
    private double totalCostEntireSale;

    public DiscountRules DiscountRules(){
        DiscountRules discountRules = new DiscountRules();
        return discountRules;
    }

    /**
     * Calculates amount discount that the customer are offered. If customer bought
     * more than 10 items, they get 5% discount.
     *
     * @param custumerSSN   Customer identification number (social security number)
     * @param saleDetails   details about the sale and items bought
     * @return              total price for sale including discount.
     */
    public double calculateDiscount(long custumerSSN, Sale saleDetails){
        int totalItemsBought = saleDetails.getTotalItemQuantityInSale();

        if(totalItemsBought > 10){
            calculateNewPrice(saleDetails);
            return newPrice(saleDetails);
        }


        return saleDetails.getTotalPriceForSale();
    }

    private double newPrice(Sale saleDetails) {
        return saleDetails.getTotalPriceForSale();
    }

    private void calculateNewPrice(Sale saleDetails) {
        saleDetails.setTotalPriceForSale(saleDetails.getTotalPriceForSale() * 0.95);
    }
}
