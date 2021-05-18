package se.kth.iv1350.POS.model;


/**
 * Class that handles discounts and rules based on information about the customer and
 * the current sale.
 *
 */

public class DiscountRules {
    DiscountEligability discountFirstCase;
    DiscountEligability discountSecondCase;

    /**
     * assigns instances of <code>DiscountFirstCase</code> and <code>DiscountSecondCase</code>
     *
     *
     * @param discountFirstCase instance created by controller
     * @param discountSecondCase instance created by the controller
     */
    public DiscountRules(DiscountFirstCase discountFirstCase, DiscountSecondCase discountSecondCase) {
        this.discountFirstCase = discountFirstCase;
        this.discountSecondCase = discountSecondCase;
    }

    /**
     * implements strategy pattern. if customer are eligiable for first discount
     * they get second discount
     *
     * @param custumerSSN   Customer identification number (social security number)
     * @param saleDetails   details about the sale and items bought
     * @return              total price for sale including discount.
     */
    public double calculateDiscount(long custumerSSN, Sale saleDetails){
        double priceHolder = saleDetails.getTotalPriceForSale();
        discountFirstCase.calculateDiscount(custumerSSN,saleDetails);

        if(priceHolder != saleDetails.getTotalPriceForSale())
            discountSecondCase.calculateDiscount(custumerSSN,saleDetails);


        return saleDetails.getTotalPriceForSale();
    }

}
