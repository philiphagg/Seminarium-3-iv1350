package se.kth.iv1350.POS.model;

import java.util.ArrayList;
import java.util.List;

/**
 * First algorithm of the strategy pattern. That gives discount if custumer's included
 * in the loyal customer list.
 */
public class DiscountFirstCase implements DiscountEligability{
    private List<Long> customerList;

    /**
     *  creates a new instance of DiscountFirstClass and adds customers to the list.
     *  customers added are for the RunFakeExcecution
     *
     */
    public DiscountFirstCase() {
        this.customerList = new ArrayList<>();
        customerList.add(1L);
        customerList.add(2L);
        customerList.add(3L);
    }

    /**
     * Strategy A from the strategy pattern. Algorithm gives 10% discount if customer
     * are included in the loyal customerlist.
     *
     * @param custumerSSN customer identification
     * @param saleDetails details about the sale
     */
    @Override
    public void calculateDiscount(long custumerSSN, Sale saleDetails) {
        for(long customer : customerList){
            if (custumerSSN == customer){
                saleDetails.setTotalPriceForSale(saleDetails.getTotalPriceForSale() * 0.9);

            }
        }
    }
}
