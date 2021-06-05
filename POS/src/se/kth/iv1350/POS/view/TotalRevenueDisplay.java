package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.SaleObserver;

/**
 * Class that implement saleobserver interface. Classes
 * that shall observ extends this class and it's abstract
 * methods.
 */
public abstract class TotalRevenueDisplay implements SaleObserver {
    private double totalRevenue;

    protected TotalRevenueDisplay(){
        totalRevenue = 0;
    }

    /**
     * Method should calculate totalrevenue of each sale
     * and execute tasks for each observer that
     * extends from this class.
     *
     * @param priceOfMostRecentSale
     */
    public void saleFinished (double priceOfMostRecentSale){
        calculateTotalRevenue(priceOfMostRecentSale);
        showTotalIncome();
    }

    private void showTotalIncome(){
        try{
            executeShowTotalIncome(totalRevenue);
        }catch(Exception e){
            handleErrors(e);
        }

    }



    protected abstract void executeShowTotalIncome(double totalRevenue);
    protected abstract void handleErrors(Exception e);

    private void calculateTotalRevenue(double priceOfMostRecentSale){
        totalRevenue += priceOfMostRecentSale;
    }
}
