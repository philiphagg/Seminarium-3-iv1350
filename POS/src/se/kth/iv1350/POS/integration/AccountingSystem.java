package se.kth.iv1350.POS.integration;

import java.util.ArrayList;

public class AccountingSystem {
    ArrayList<ReceiptDTO> AccountingSystem;

    AccountingSystem(){
        AccountingSystem = new ArrayList<ReceiptDTO>();
    }

    /**
     * adds a receipt to the accountingsystem
     * @param receiptDTO
     */
    public void updateAccountingSystem(ReceiptDTO receiptDTO){

        AccountingSystem.add(receiptDTO);
    }
}
