package se.kth.iv1350.POS.integration;

import java.util.ArrayList;


/**
 * class that should communicate with external accounting system.
 *
 *
 *
 */
public class AccountingSystem {
    ArrayList<ReceiptDTO> AccountingSystem;


    AccountingSystem(){
        AccountingSystem = new ArrayList<>();
    }

    /**
     * adds a receipt to the accountingsystem.
     *
     * this method is not a part of seminar 3.
     *
     * @param receiptDTO
     */
    public void updateAccountingSystem(ReceiptDTO receiptDTO){

        AccountingSystem.add(receiptDTO);
    }
}
