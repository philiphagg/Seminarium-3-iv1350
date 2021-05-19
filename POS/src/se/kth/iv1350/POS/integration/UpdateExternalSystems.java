package se.kth.iv1350.POS.integration;

import se.kth.iv1350.POS.integration.ReceiptDTO;

public interface UpdateExternalSystems {

    void updateSystem(ReceiptDTO receiptDTO);
}
