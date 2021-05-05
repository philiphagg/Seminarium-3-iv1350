package se.kth.iv1350.POS.integration;


/**
 * Class that is responsible for booting the integration layer. It will create all appropriate
 * objects upon startup.
 */

public class SystemStartup {
    InventorySystem inventorySystem;
    AccountingSystem accountingSystem;
    Register register;
    Printer printer;


    /**
     * assigning new objects the appropriate fields.
     */
    public SystemStartup(){
        this.accountingSystem = new AccountingSystem();
        this.inventorySystem = new InventorySystem();
        this.register = new Register();
        this.printer = new Printer();
    }

    /**
     * Extracts attributes from the object <code>SystemStartUp</code>
     *
     * @return  reference to inventory system
     */
    public InventorySystem getInventorySystem() {
        return inventorySystem;
    }


    /**
     * Extracts attributes from the object <code>SystemStartUp</code>
     *
     * @return  reference to Accounting system
     */

    public AccountingSystem getAccountingSystem() {
        return accountingSystem;
    }

    /**
     * Extracts attributes from the object <code>SystemStartUp</code>
     *
     * @return  reference to register
     */
    public Register getRegister() {
        return register;
    }

    /**
     * Extracts attributes from the object <code>SystemStartUp</code>
     *
     * @return  reference to printer
     */
    public Printer getPrinter() {
        return printer;
    }
}
