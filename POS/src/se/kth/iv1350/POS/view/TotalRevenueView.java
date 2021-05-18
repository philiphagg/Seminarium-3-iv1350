package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.SaleObserver;


/**
 * shows the total revenue in the user interface for business administration
 */
public class TotalRevenueView implements SaleObserver {
    double totalRevenue;

    /**
     *
     * @param totalRev
     */
    @Override
    public void saleRevenue(double totalRev) {
        calculateTotalRev(totalRev);
        System.out.println("***************************");
        System.out.println("* Current revenue: "+totalRevenue+"  *");
        System.out.println("***************************");
    }

    @Override
    public void calculateTotalRev(double totalPrice) {
        totalRevenue += totalPrice;
    }

}
