package se.kth.iv1350.POS.model;

/**
 * interface that specifies the strategy pattern algorithm
 */
public interface DiscountEligability {


    void calculateDiscount(long custumerSSN, Sale saleDetails);
}
