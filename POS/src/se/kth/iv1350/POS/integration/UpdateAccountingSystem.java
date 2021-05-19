package se.kth.iv1350.POS.integration;


/**
 * Class responsible for updating the external inventorysystem
 *
 */
public class UpdateAccountingSystem implements UpdateExternalSystems{
    SystemStartup systemStartup;
    AccountingSystem accountingSystem;

    /**
     * null constructor
     */
    public UpdateAccountingSystem() {
    }

    /**
     * Constructor that extract reference to accountingsystem
     *
     * @param systemStartup object containing the accountingsystem
     */
    public UpdateAccountingSystem(SystemStartup systemStartup) {
        this.systemStartup = systemStartup;
        this.accountingSystem = systemStartup.getAccountingSystem();
    }

    /**
     * Task that updates the accountingsystem
     *
     * @param receiptDTO    object holding all information
     *                      about current sale
     */
    @Override
    public void updateSystem(ReceiptDTO receiptDTO) {
        accountingSystem.updateAccountingSystem(receiptDTO);

    }


}
