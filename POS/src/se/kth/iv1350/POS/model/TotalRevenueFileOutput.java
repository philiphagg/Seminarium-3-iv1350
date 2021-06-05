package se.kth.iv1350.POS.model;

import se.kth.iv1350.POS.util.FileLogger;
import se.kth.iv1350.POS.view.TotalRevenueDisplay;

import java.io.IOException;


/**
 * responsible for writing total revenue to a file.
 *
 */
public class TotalRevenueFileOutput extends TotalRevenueDisplay {
    FileLogger fileLogger;
    String fileLocation = "POS/src/se/kth/iv1350/POS/model/Revenue.txt";

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

    @Override
    protected void executeShowTotalIncome(double totalRevenue) {
        fileLogger.log(Double.toString(totalRevenue));
    }

    @Override
    protected void handleErrors(Exception e) {
        System.out.println("something went wrong, cannot log at current time");

    }

}
