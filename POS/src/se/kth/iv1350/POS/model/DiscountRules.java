package se.kth.iv1350.POS.model;

public class DiscountRules {
    private int numberOfItemBought;
    private int identfier; // item bought
    private double totalCostEntireSale;

    public DiscountRules DiscountRules(){
        DiscountRules discountRules = new DiscountRules();
        return discountRules;
    }

    /**
     * if more than 10 items bought get 5% discount
     * */
    public double calculateDiscount(long custumerSSN, Sale saleDetails){
        int totalItemsBought = saleDetails.getTotalItemQuantityInSale();

        if(totalItemsBought > 10){
            saleDetails.setTotalPriceForSale(saleDetails.getTotalPriceForSale() * 0.95);
            return saleDetails.getTotalPriceForSale();
        }


        return saleDetails.getTotalPriceForSale();
    }
}
