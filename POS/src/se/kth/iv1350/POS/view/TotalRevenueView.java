package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.SaleObserver;


/**
 * shows the total revenue in the user interface for business administration
 */
public class TotalRevenueView extends TotalRevenueDisplay {





    @Override
    protected void executeShowTotalIncome(double totalRevenue) {
        System.out.println("***************************");
        System.out.println("*  Current revenue: "+totalRevenue+"  *");
        System.out.println("***************************");
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("Error occured, can not display total revenue at this time");
    }
}
