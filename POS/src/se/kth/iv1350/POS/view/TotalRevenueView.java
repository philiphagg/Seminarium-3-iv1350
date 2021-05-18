package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.SaleObserver;


/**
 * shows the total revenue in the user interface for business administration
 */
public class TotalRevenueView implements SaleObserver {
    double totalRevenue;

    /**
     *  Prints the total revenue to the console.
     *
     * @param totalRev  revenue that shall be printed
     */
    @Override
    public void saleRevenue(double totalRev) {
        calculateTotalRev(totalRev);
        System.out.println("***************************");
        System.out.println("* Current revenue: "+totalRevenue+"  *");
        System.out.println("***************************");
    }

    /**
     * Calculates the total price for all sales since program started
     *
     * @param totalPrice    total price for this sale instance
     */
    @Override
    public void calculateTotalRev(double totalPrice) {
        totalRevenue += totalPrice;
    }

}
