package se.kth.iv1350.POS.model;

/**
 * Sale observers that observes the total price for sale.
 */
public interface SaleObserver {


    void saleRevenue(double totalRev);
    void calculateTotalRev(double totalPrice);
}
