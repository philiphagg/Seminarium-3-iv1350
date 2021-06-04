package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.util.FileLogger;

import java.io.IOException;


/**
 * responsible for writing total revenue to a file.
 *
 */
public class TotalRevenueFileOutput implements SaleObserver {
    FileLogger fileLogger;
    String fileLocation = "POS/src/se/kth/iv1350/POS/model/Revenue.txt";
    double totalRevenue;

    /**
     * Creates instance of the <code>TotalRevenueFileOutput</code> and
     * creates a new <code>Filelogger</code> and assigns this to
     * <code>fileLogger</code>
     *
     *
     * @throws IOException exceptions thrown when
     */
    public TotalRevenueFileOutput() throws IOException {
        fileLogger = new FileLogger(fileLocation);
    }

    /**
     * Calculates total revenue and logs to file
     *
     * @param totalRev total revenue for the sale
     */
    @Override
    public void saleRevenue(double totalRev) {
        calculateTotalRev(totalRev);
        fileLogger.log(revToString());
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


    private String revToString() {

        return Double.toString(totalRevenue);

    }
}
