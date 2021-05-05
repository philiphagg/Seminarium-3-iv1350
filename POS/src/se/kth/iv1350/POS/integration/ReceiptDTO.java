package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.model.Sale;

import java.time.LocalDateTime;

/**
 * class that represents the ReceiptDTO. Can be sent through different layers
 *
 */

public class ReceiptDTO {
    private static final String storeStreet = "Glada gatan";
    private static final int storeStreetNo = 1337;
    private static final String storeCity = "Happy Town";
    private static final String storeName = "Godtyclig Livs";
    private double amountPaid;
    private double amountChange;
    private Sale saleDetails;
    private LocalDateTime dateTime;


    /**
     * Creates a receipt data transfer object. To send data between layers in the system.
     * also logs date and time for the sale upton creation.
     *
     * @param amountPaid    amounth customer pays for sale
     * @param amountChange  amount change after payment
     * @param saleDetails   details about each sale.
     */
    public ReceiptDTO(double amountPaid, double amountChange, Sale saleDetails) {

        this.amountPaid = amountPaid;
        this.amountChange = amountChange;
        this.saleDetails = saleDetails;
        this.dateTime = LocalDateTime.now(); // här kan man lägga in operationen för att hämta datetime
    }


    static String getStoreStreet() {
        return storeStreet;
    }

    static int getStoreStreetNo() {
        return storeStreetNo;
    }

    static String getStoreCity() {
        return storeCity;
    }

    static String getStoreName() {
        return storeName;
    }

    double getAmountPaid() {
        return amountPaid;
    }

    double getAmountChange() {
        return amountChange;
    }

    Sale getSaleDetails() {
        return saleDetails;
    }

    LocalDateTime getDateTime() {
        return dateTime;
    }

}
